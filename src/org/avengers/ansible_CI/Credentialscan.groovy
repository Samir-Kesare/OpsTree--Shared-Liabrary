package org.avengers.ansible_CI
def call(String gitleaksVersion) {
  stage('Credential Scanning') {
            script {
                sh "wget https://github.com/gitleaks/gitleaks/releases/download/v${gitleaksVersion}/gitleaks_${gitleaksVersion}_linux_x64.tar.gz"
                // Extract Gitleaks
                sh "tar xvzf gitleaks_${gitleaksVersion}_linux_x64.tar.gz"
                sh "./gitleaks detect -r credScanReport.json"
            }
        }
}
