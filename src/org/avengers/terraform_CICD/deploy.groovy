package org.avengers.terraform_CICD

def call(String rootPath, String childPath) {
    stage("Terraform apply") {
        script {
            sh "cd ${rootPath}/${childPath} && terraform apply -auto-approve"
        }
    }
}
