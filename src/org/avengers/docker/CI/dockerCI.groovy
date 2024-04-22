package org.avengers.docker.CI

def createImage(String imageName, String dockerfilePath) {
  
  stage('Create Docker Image'){
        sh "docker build -t ${imageName} ${dockerfilePath}"    
  }
}
