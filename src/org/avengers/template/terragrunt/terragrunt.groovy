package org.avengers.template.terragrunt

def terragruntInit() {
    stage('Terragrunt Init') {
        // Perform dp check
        sh 'terragrunt init'
    }
}

def terragruntPlan() {
    stage('Terragrunt Plan') {
        sh 'terragrunt plan'
    }
}

def terragruntApply() {
    stage('Terragrunt Apply') {
        sh 'terragrunt apply --auto-approve'
    }
}
