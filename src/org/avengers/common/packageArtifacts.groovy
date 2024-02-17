package org.avengers.common

def call() {
    stage('Build') {
        steps {
            script {
                // Package artifacts minus the testing
                sh 'mvn clean package -DskipTests=true'
            }
        }
    }
}
