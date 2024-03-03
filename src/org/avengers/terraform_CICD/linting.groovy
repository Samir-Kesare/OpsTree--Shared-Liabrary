package org.avengers.terraform_CICD

def call(String rootPath, String childPath) {
    stage('Static Code Analysis') {
        script {
            sh "cd ${rootPath}/${childPath} && tflint --format default | tee tflint_report.json"
        }
    }
}
