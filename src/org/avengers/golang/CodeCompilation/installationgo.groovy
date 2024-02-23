package org.avengers.golang.CodeCompilation

def call() {
    stage('Installation Pre-Requisites') {
        script {
            // Ensure Go is available in the environment
            def goHome = tool 'go1.22.0'
            env.PATH = "${goHome}/bin:${env.PATH}"
            sh 'go install'
        }
    }
}
