package org.avengers.asg_tfmodule_CICD

def call(String rootPath, String childPath, String tagVersion) {
    stage("Terraform action") {
        script {
            sh "cd ${rootPath}/${childPath}"
        }
    }



    stage('checkov') {
        script {
            // Stage to run Checkov for Terraform
            sh "cd ${rootPath}/${childPath} && /var/lib/jenkins/.local/bin/checkov -d . -s --output-file-path . --skip-path ./tflint_report.jsonֿ"
        }
    }



    stage('Terraform fmt') {
        script {
            // Stage to format Terraform files
            sh "cd ${rootPath}/${childPath} && terraform fmt"
        }
    }



    stage("Pem Key Archive") {
        script {
            // Archive PEM key artifacts
            archiveArtifacts artifacts: "${rootPath}/${childPath}/*.pem", allowEmptyArchive: true
        }
    }



    stage('Static Code Analysis') {
        script {
            // Install TFLint and run static code analysis
            sh "curl -s https://raw.githubusercontent.com/terraform-linters/tflint/master/install_linux.sh | sudo bash"
            sh "cd ${rootPath}/${childPath} && tflint --format default | tee tflint_report.json"
        }
    }



    stage('Terraform Validate') {
        script {
            // Validate Terraform configurations
            sh "cd ${rootPath}/${childPath} && terraform validate"
        }
    }


    stage('Terraform init') {
        script {
            // Initialize Terraform working directory
            sh "cd ${rootPath}/${childPath} && terraform init"
        }
    }

  stage('Git Tag Stage') {
            script {
                // Tag the version
                sh "git tag -a v${tagVersion} -m 'Version ${tagVersion}'"
            }
        }
}
