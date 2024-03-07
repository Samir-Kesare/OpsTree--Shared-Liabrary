package org.avengers.terraform_CICD

def call(String rootPath, String childPath) {
    stage("Terraform Plan") {
        script {
            sh "cd ${rootPath}/${childPath} && terraform plan"
        }
    }

    stage("Terraform Apply") {
        script {
            sh "cd ${rootPath}/${childPath} && terraform apply -auto-approve"
        }
    }
}
