package org.avengers.asg_tfmodule_CICD

def call(String rootPath, String childPath) {
    stage("Terraform action") {
        script {
            sh "cd ${rootPath}/${childPath}"
        }
    }
}

def call(String rootPath, String childPath) {
    stage('checkov') {
        script {
            // Stage to run Checkov for Terraform
            sh "cd ${rootPath}/${childPath} && /var/lib/jenkins/.local/bin/checkov -d . -s --output-file-path . --skip-path ./tflint_report.jsonֿ"
        }
    }
}

def call(String rootPath, String childPath) {
    stage('Terraform fmt') {
        script {
            // Stage to format Terraform files
            sh "cd ${rootPath}/${childPath} && terraform fmt"
        }
    }
}

def call(String rootPath, String childPath) {
    stage("Pem Key Archive") {
        script {
            // Archive PEM key artifacts
            archiveArtifacts artifacts: "${rootPath}/${childPath}/*.pem", allowEmptyArchive: true
        }
    }
}

def call(String rootPath, String childPath) {
    stage('Static Code Analysis') {
        script {
            // Install TFLint and run static code analysis
            sh "curl -s https://raw.githubusercontent.com/terraform-linters/tflint/master/install_linux.sh | sudo bash"
            sh "cd ${rootPath}/${childPath} && tflint --format default | tee tflint_report.json"
        }
    }
}

def call(String rootPath, String childPath) {
    stage('Terraform Validate') {
        script {
            // Validate Terraform configurations
            sh "cd ${rootPath}/${childPath} && terraform validate"
        }
    }
}

def call(String rootPath, String childPath) {
    stage('Terraform init') {
        script {
            // Initialize Terraform working directory
            sh "cd ${rootPath}/${childPath} && terraform init"
        }
    }
}
def call(String tagVersion) {
  stage('Git Tag Stage') {
            script {
                // Tag the version
                sh "git tag -a v${tagVersion} -m 'Version ${tagVersion}'"
            }
        }
}
