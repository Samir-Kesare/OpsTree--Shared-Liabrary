package org.avengers.blue_green

def init(String rootPath, String greenPath) {
    stage('Terragrunt Init') {
        sh "cd ${rootPath}/${greenPath} && terragrunt run-all --terragrunt-non-interactive  init"
    }
}

def plan(String rootPath, String greenPath) {
    stage('Terragrunt Plan') {
        sh "cd ${rootPath}/${greenPath} && terragrunt plan -var='traffic_distribution=blue'"

    }
}

def createGreenTG(String rootPath, String greenPath) {
    stage('Create Green TG') {
       sh "cd ${rootPath}/${greenPath} && terragrunt apply -auto-approve -var='traffic_distribution=blue'"
    }
}

def destroy(String rootPath, String greenPath) {
    stage('Terragrunt Destroy') {
        sh "cd ${rootPath}/${greenPath} && terragrunt destroy -auto-approve"
    }
}

def healthCheck(String rootPath, String greenPath) {
        stage('Store TG arn'){
            def green_tg_arn = sh(
                returnStdout: true,
                script: "cd ${rootPath}/${greenPath} && terragrunt output final_target_group_arn").trim()
                env.GREEN_TG_ARN = green_tg_arn
        }
        stage('TG Health Check') {
            sh "aws elbv2 describe-target-health --target-group-arn ${env.GREEN_TG_ARN} | grep State"
        }
}
def deployGreen(String rootPath, String greenPath) {
    stage('Deploy Green') {
        sh "cd ${rootPath}/${greenPath} && terragrunt apply -auto-approve -var='traffic_distribution=green'"
    }
}
def destroyBlue(String rootPath, String bluePath) {
    stage('Destroy Blue') {
        // sh "cd ${rootPath}/${bluePath} && terragrunt init -auto-approve -var='traffic_distribution=green'"
        sh "cd ${rootPath}/${bluePath} && terragrunt apply -auto-approve -var='min_size=0' -var='max_size=0' -var='desired_capacity=0'"
    }
}
