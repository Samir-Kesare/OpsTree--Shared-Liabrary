package org.avengers.java.bugAnalysis

def call() {
          stage('Publish HTML Report') {
                      publishHTML([
                          allowMissing: false,
                          alwaysLinkToLastBuild: true,
                          keepAll: true,
                          reportDir: 'target/site',
                          reportFiles: 'spotbugs.html',
                          reportName: 'SpotBugs Report'
                      ])
                  }
              }
