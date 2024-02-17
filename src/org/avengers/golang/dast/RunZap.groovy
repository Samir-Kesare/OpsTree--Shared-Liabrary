package org.avengers.golang.dast
def call() {
stage('Run ZAP Scan') {
            steps {
                 // Start ZAP and perform the scan
                  sh "/var/lib/jenkins/workspace/'Declarative Pipeline GoLang DAST'/ZAP_$(zapVersion)/zap.sh -cmd -port 8090 -quickurl http://43.207.90.113:8080/api/v1/employee/health -quickprogress -quickout out2.html"
                }
            }
        }
