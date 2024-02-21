package org.avengers..GoLangDependencyScanning

def call() {
    stage('Clean workspace') {
        script {
           sh "rm -rf *.zip"
           sh "rm -rf dependency-check"
        }
    }
}
