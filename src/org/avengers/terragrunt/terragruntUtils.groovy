package org.avengers.terragrunt

class TerragruntUtils {
    def init(String rootPath, String childPath) {
        stage('Terragrunt Init') {
            sh 'cd ${rootPath}/${childPath} && terragrunt init'
        }
    }

    def plan(String rootPath, String childPath) {
        stage('Terragrunt Plan') {
            sh 'cd ${rootPath}/${childPath} && terragrunt plan'
        }
    }

    def apply(String rootPath, String childPath) {
        stage('Terragrunt Apply') {
            sh 'cd ${rootPath}/${childPath} && terragrunt apply'
        }
    }
}
