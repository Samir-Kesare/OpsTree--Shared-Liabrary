package org.avengers.docker.createImage

def call(String imageName, String dockerfilePath) {
  
  stage('Create Docker Image'){
        sh "docker build -t ${imageName} ${dockerfilePath}"    
  }
}
