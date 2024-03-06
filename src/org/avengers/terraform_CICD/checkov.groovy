package org.avengers.terraform_CICD

def call(String rootPath, String childPath) {
    stage('checkov') {
        script {
            //sh "pip install checkov"
            sh "python3 -m pip install checkov"
            sh "cd ${rootPath}/${childPath} && checkov --directory . || true"
        }
    }
}
