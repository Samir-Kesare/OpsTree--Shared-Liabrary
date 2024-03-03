package org.avengers.terraform_CICD

def call(String rootPath, String childPath) {
    stage('checkov') {
        script {
            sh "cd ${rootPath}/${childPath} && checkov --directory . || true"
        }
    }
}
