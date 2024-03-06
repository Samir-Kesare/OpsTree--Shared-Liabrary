package org.avengers.terraform_CICD

def call(String rootPath, String childPath) {
    stage('Static Code Analysis') {
        script {
            sh "curl -s https://raw.githubusercontent.com/terraform-linters/tflint/master/install_linux.sh | sudo bash"
            sh "cd ${rootPath}/${childPath} && tflint --format default | tee tflint_report.json"
        }
    }
}
