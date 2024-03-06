package org.avengers.common

def call(String reportName){
  stage('Archive') {
        script {
           archiveArtifacts artifacts: "**/${reportName}"
        }
    }
  
}
