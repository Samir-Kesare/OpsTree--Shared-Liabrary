package org.avengers.blue_green

def init(String rootPath, String childPath) {
    stage('Terragrunt Init') {
        sh "cd ${rootPath}/${childPath} && terragrunt run-all --terragrunt-non-interactive  init"
    }
}

def plan(String rootPath, String childPath, String extraVars) {
    stage('Terragrunt Plan') {
        sh "cd ${rootPath}/${childPath} && terragrunt plan  --terragrunt-disable-command-validation  ${extraVars}"
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

def healthCheck(String rootPath, String childPath) {
        stage('TG Health Check'){
                    def green_tg_arn = sh(
                        returnStdout: true,
                        script: 'cd ${rootPath}/${childPath} && terragrunt output final_target_group_arn').trim()
                    env.GREEN_TG_ARN = green_tg_arn
                    }
        stage('Print DNS Name'){
                    sh """
                        echo ${env.GREEN_TG_ARN} 
                        aws elbv2 describe-target-health --target-group-arn ${env.GREEN_TG_ARN} | grep State
                    """
        }
}
