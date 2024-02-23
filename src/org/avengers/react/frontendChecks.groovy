package org.avengers.react

def bugAnalysis() {
    stage('Bug Analysis') {
                // steps {
                    script {
                        // sh 'sudo apt-get update && sudo apt-get install -y npm'
                        sh 'npm install'
                        sh 'npm ci'
                        sh 'echo "module.exports = { extends: \'eslint:recommended\' };" > .eslintrc.js'
                        sh 'npx eslint . --ext .js,.jsx --format html --output-file eslint-report.html || true'
                    }
                // }
    }
}

def dpCheck() {
        stage('Dependency Check') {
            // steps {
                // sh 'npm install'
                dependencyCheck additionalArguments: '--project dp-check --scan /var/lib/jenkins/workspace/frontendCI/  --format HTML', odcInstallation: 'DP-check'
            // }
        }
}
def codeAnalysis() {
stage('code analysis') {
            //steps {
            sh 'ls ${scannerHome}'
            sh 'echo ${scannerHome}'
            withSonarQubeEnv(installationName: 'sq1') { 
            withCredentials([string(credentialsId: 'frontend-sonar', variable: 'token')]) {
                sh '''
                sonar-scanner \
                  -Dsonar.projectKey=frontend-18 \
                  -Dsonar.sources=. \
                  -Dsonar.host.url=http://34.130.229.252:9000 \
                  -Dsonar.login=sqp_d82e793e10438301776a7740f7c4c16a595ece60
                '''
                }
            }
        }         
}
