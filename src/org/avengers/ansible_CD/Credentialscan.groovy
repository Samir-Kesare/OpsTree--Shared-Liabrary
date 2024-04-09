package org.avengers.ansible_CD
// def call(String gitleaksVersion) {
//   stage('Credential Scanning') {
//             script {
//               try {
//                 sh "wget https://github.com/gitleaks/gitleaks/releases/download/v${gitleaksVersion}/gitleaks_${gitleaksVersion}_linux_x64.tar.gz"
//                 // Extract Gitleaks
//                 sh "tar xvzf gitleaks_${gitleaksVersion}_linux_x64.tar.gz"
//                 sh "./gitleaks detect -r credScanReport.json"
//               }
//               catch (Exception e)  {
//               sh ' echo " Please check the cred scan report " '
//               }
              
//             }
//         }
// }
def call() {
  stage('Credential Scanning') {
            script {
              try {
                // sh "wget https://github.com/gitleaks/gitleaks/releases/download/v${gitleaksVersion}/gitleaks_${gitleaksVersion}_linux_x64.tar.gz"
                // Extract Gitleaks
                // sh "tar xvzf gitleaks_${gitleaksVersion}_linux_x64.tar.gz"
                sh "./gitleaks detect -r credScanReport.json"
              }
              catch (Exception e)  {
              sh ' echo " Please check the cred scan report " '
              }
              
            }
        }
}
