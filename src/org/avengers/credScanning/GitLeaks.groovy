package org.avengers.credScanning

def call(String gitLeaksVersion){
  stage('Download and Install Gitleaks') {
        script {
           sh "wget https://github.com/gitleaks/gitleaks/releases/download/v${gitLeaksVersion}/gitleaks_${gitLeaksVersion}_linux_x64.tar.gz"
                  // Extract Gitleaks
            sh "tar xvzf gitleaks_${gitLeaksVersion}_linux_x64.tar.gz"
        }
    }
  
}
