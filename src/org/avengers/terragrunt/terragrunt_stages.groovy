package org.avengers.java.dast

def call() {
stage('Run ZAP Scan') {
            script {
                 // Start ZAP and perform the scan
                  sh "${currentWorkspace}/ZAP_${zapVersion}/zap.sh -cmd -port 8082 -quickurl http://174.129.170.198:8080/swagger-ui/index.html -quickout ${currentWorkspace}/results.html"
                }
            }
}
