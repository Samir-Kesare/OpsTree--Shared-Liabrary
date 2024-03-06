package org.avengers.terraform_CICD

def call(String rootPath, String childPath) {
    stage("Terraform Plan") {
        script {
            sh "terraform plan"
        }
    }

    stage("Terraform Apply") {
        script {
            sh "terraform apply -auto-approve"
        }
    }
}
