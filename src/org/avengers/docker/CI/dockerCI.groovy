package org.avengers.docker.CI

def createImage(String imageName, String dockerfilePath) {
    // sudo docker build -t ${imageName} ${dockerfilePath}  
   // sudo docker rmi -f df53b9875ae3
  // sudo docker images
  stage('Create Docker Image'){
    sh """
      docker images
    """    
  }
}
