package org.avengers.terraform_CICD

def call(String rootPath, String childPath, String action) {
    stage("Terraform ${action}") {
        script {
            sh "cd ${rootPath}/${childPath} && terraform ${action}"
        }
    }
}
