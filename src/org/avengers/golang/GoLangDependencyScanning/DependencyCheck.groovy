package org.avengers.GoLangDependencyScanning

def call() {
    stage('Run Dependency Check') {
        script {
           sh "dependency-check/bin/dependency-check.sh --scan /var/lib/jenkins/workspace/ --out dep-check.html"
        }
    }
}
