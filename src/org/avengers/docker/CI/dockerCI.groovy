package org.avengers.docker.CI

def createImage(String imageName, String dockerfilePath) {
   // sudo docker build -t ${imageName} ${dockerfilePath}
    
  stage('Create Docker Image'){
    sh """
      sudo docker images
      sudo docker rmi -f df53b9875ae3
      sudo docker images
    """    
  }
}
