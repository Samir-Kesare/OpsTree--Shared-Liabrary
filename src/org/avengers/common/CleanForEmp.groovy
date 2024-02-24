
package org.avengers.common

def call(String gitLeaksReport, String uniTestReport, String BugAnalysisreport, String depreport){
  stage('Archive and Clean Workspace') {
        script {
           archiveArtifacts artifacts: "**/${gitLeaksReport}"
           archiveArtifacts artifacts: "**/${uniTestReport}"
           archiveArtifacts artifacts: "**/${BugAnalysisreport}"
           archiveArtifacts artifacts: "**/${depreport}"
           cleanWs()
        }
    }
  
}
