package org.avengers.common

def call() {
    stage('Build') {
        script {
                // Package artifacts minus the testing
            sh 'mvn clean package -DskipTests=true'
        }
    }
}
