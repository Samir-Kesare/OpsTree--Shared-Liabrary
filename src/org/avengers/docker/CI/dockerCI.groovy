package org.avengers.docker.CI

def createImage(String imageName, String dockerfilePath) {
   //     id
  //     sudo systemctl restart docker
 //     groups jenkins
//     ls -l /var/run/docker.sock
    stage('Create Docker Image'){
    sh """
        sudo docker build -t ${imageName} ${dockerfilePath}  
        sudo docker images
    """    
  }
}
def trivyCheck(String imageName) {
    stage('trivy Scan'){
    sh """
       trivy --no-progress ${imageName}:latest
    """    
  }
}
