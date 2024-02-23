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
    def scannerHome = tool 'SonarScanner';
    withSonarQubeEnv('sq1') {
        //sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=frontend-18 -Dsonar.sources=. -Dsonar.host.url=http://10.188.0.3:9000  -Dsonar.login=sqp_d82e793e10438301776a7740f7c4c16a595ece60"
        sh "/var/lib/jenkins/tools/hudson.plugins.sonar.MsBuildSQRunnerInstallation/SonarScanner/sonar-scanner-5.0.1.3006/bin/sonar-scanner -Dsonar.projectKey=frontend-18 -Dsonar.sources=. -Dsonar.host.url=http://10.188.0.3:9000  -Dsonar.login=sqp_d82e793e10438301776a7740f7c4c16a595ece60"
    }
            
        // withSonarQubeEnv(installationName: 'sq1') {
                
            // sh 'ls ${scannerHome}'
            // sh 'echo ${scannerHome}'
            // withCredentials([string(credentialsId: 'frontend-sonar', variable: 'token')]) {
             // sonar-scanner \

                // sh '''
             
                // /opt/sonarqube/current/bin/linux-x86-64/sonar.sh \
                //   -Dsonar.projectKey=frontend-18 \
                //   -Dsonar.sources=. \
                //   -Dsonar.host.url=http://34.130.229.252:9000 \
                //   -Dsonar.login=sqp_d82e793e10438301776a7740f7c4c16a595ece60
                // '''
                // // }
            // }
        }         
}
// node {
//   stage('SCM') {
//     checkout scm
//   }
//   stage('SonarQube Analysis') {
//     def scannerHome = tool 'SonarScanner';
//     withSonarQubeEnv() {
//       sh "${scannerHome}/bin/sonar-scanner"
//     }
//   }
// }
