package org.avengers.common

def call(String reportName){
  stage('Archive and Clean Workspace') {
        script {
           archiveArtifacts artifacts: "**/${reportName}"
           cleanWs()
        }
    }
  
}
