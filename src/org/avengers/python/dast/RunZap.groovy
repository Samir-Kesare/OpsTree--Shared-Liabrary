package org.avengers.python.dast
def call(String zapVersion) {
stage('Run ZAP Scan') {
            script {
                 // Start ZAP and perform the scan
                  sh "/var/lib/jenkins/workspace/'DAST_declarative'/ZAP_${zapVersion}/zap.sh -cmd -port 8090 -quickurl http://43.207.90.113:8080/api/v1/attendance/health -quickprogress -quickout out2.html"
                }
            }
        }
