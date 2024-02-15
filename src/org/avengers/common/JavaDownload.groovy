package org.avengers.common

def call(String javaVersion) {
    stage('Install Java') {
        script {
            sh "sudo apt update && sudo apt install -y openjdk-${javaVersion}-jdk"
        }
    }
}
