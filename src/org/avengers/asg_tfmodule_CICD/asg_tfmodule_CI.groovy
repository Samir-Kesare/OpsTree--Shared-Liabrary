package org.avengers.asg_tfmodule_CICD

def call(String rootPath, String childPath, String tagVersion) {
    stage("Terraform action") {
        script {
            sh "cd ${rootPath}/${childPath}"
        }
    }
    
    stage('checkov') {
        script {

            // Check if Checkov is installed
            def checkovInstalled = sh(script: 'command -v checkov', returnStatus: true)

            if (checkovInstalled == 0) {
                echo "Checkov is already installed."
            } else {
                echo "Checkov is not installed. Installing..."
                sh "pip install checkov"
                sh "python3 -m pip install checkov"
                sh 'echo "export PATH=\"`python3 -m site --user-base`/bin:\$PATH\"" >> ~/.bashrc'
                sh "sudo apt install pipenv -y"
                sh "pip install checkov"
                
            }
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
