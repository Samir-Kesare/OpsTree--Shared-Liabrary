package org.avengers.golang.StaticAnalysis

def call() {
    stage('SonarQube Analysis') {
        withSonarQubeEnv('sq1') {
            sh "/var/lib/jenkins/tools/hudson.plugins.sonar.MsBuildSQRunnerInstallation/SonarScanner/sonar-scanner-5.0.1.3006/bin/sonar-scanner -Dsonar.projectKey=gloang-static-01 -Dsonar.sources=. -Dsonar.host.url=http://10.188.0.3:9000  -Dsonar.login=sqp_baf01327c387b84a45b8796884f8bdcd2f3c7097"
        }
    }
}
