package org.avengers.ansible_CI
def call() {
  stage('Credential Scanning') {
            script {
                sh 'wget https://github.com/gitleaks/gitleaks/releases/download/v8.18.2/gitleaks_8.18.2_linux_x64.tar.gz'
                // Extract Gitleaks
                sh 'tar xvzf gitleaks_8.18.2_linux_x64.tar.gz'
                sh './gitleaks detect -r credScanReport.json'
            }
        }
}
