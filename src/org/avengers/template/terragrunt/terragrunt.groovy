package org.avengers.template.terragrunt

def terragruntInit() {
    sh 'terragrunt init'
}

def terragruntPlan() {
    sh 'terragrunt plan'
}

def terragruntApply() {
    sh 'terragrunt apply --auto-approve'
}
