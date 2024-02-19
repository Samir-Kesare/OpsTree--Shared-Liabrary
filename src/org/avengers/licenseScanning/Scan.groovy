package org.avengers.licenseScanning

def call() {
    stage('FOSSA Analyze & Test') {
        script {
            sh 'fossa analyze'
            sh 'fossa test'
        }
    }
}
