package org.avengers.terragrunt

class TerragruntUtils {
    def init() {
        stage('Terragrunt Init') {
            sh 'terragrunt init'
        }
    }

    def plan() {
        stage('Terragrunt Plan') {
            sh 'Terragrunt plan'
        }
    }

    def apply() {
        stage('Terragrunt Apply') {
            sh 'terragrunt apply'
        }
    }
}
