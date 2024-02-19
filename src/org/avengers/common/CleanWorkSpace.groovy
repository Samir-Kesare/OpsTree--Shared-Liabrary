package org.avengers.common
// Always Clean 
def call(){
  stage('Clean Workspace') {
        script {
           cleanWs()
        }
    }
  
}
