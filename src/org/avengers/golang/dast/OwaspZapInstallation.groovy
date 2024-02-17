package org.avengers.golang.dast
def call(String zapVersion) {
  stage('Install ZAP') {
    script {
         // Download and install OWASP ZAP
          sh 'wget https://github.com/zaproxy/zaproxy/releases/download/v${zapVersion}/ZAP_${zapVersion}_Linux.tar.gz'
          sh 'tar -xvf ZAP_${zapVersion}_Linux.tar.gz'
                    
                }
            }
        }

