package org.avengers.blue_green

def init(String rootPath, String childPath) {
    stage('Terragrunt Init') {
        sh "cd ${rootPath}/${childPath} && terragrunt init"
    }
}

def plan(String rootPath, String childPath, String extraVars) {
    stage('Terragrunt Plan') {
        sh "cd ${rootPath}/${childPath} && terragrunt plan ${extraVars}"
    }
}

def apply(String rootPath, String childPath, String extraVars) {
    stage('Terragrunt Apply') {
        sh "cd ${rootPath}/${childPath} && terragrunt apply -auto-approve ${extraVars}"
    }
}

def destroy(String rootPath, String childPath) {
    stage('Terragrunt Destroy') {
        sh "cd ${rootPath}/${childPath} && terragrunt destroy -auto-approve"
    }
}
