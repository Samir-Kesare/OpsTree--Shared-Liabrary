package org.avengers.credScanning

def call(String reportName) {
  stage('Gitleaks Scan') {
        script {
           sh "./gitleaks detect -r ${reportName}"
        }
    }
  
}
