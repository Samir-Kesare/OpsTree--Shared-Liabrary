package org.avengers.golang.GoLangDependencyScanning

def call(String depreport) {
    stage('Run Dependency Check') {
        script {
           sh "dependency-check/bin/dependency-check.sh --scan /var/lib/jenkins/workspace/ --out ${depreport}"
        }
    }
}
