package org.avengers.common

def call(String reportName){
  stage('Clean Workspace') {
        script {
           cleanWs()
        }
    }
  
}
