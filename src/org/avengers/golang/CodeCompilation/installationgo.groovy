package org.avengers.golang.CodeCompilation

def call() {
    stage('Installation Pre-Requisites') {
        script {
            // Update apt packages
            sudo -S apt update
            // Install Go using snap
            sh 'sudo snap install go --classic'
          
       }
    }
}
