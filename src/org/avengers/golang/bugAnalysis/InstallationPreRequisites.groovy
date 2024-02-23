
package org.avengers.golang.bugAnalysis

def call() {
    stage('Installation Pre-Requisites (Golang)') {
        script {
            // Update apt packages
            sh 'sudo apt update'
            // Install Go using snap
            sh 'sudo snap install go --classic'
            // Remove golangci-lint using snap
            sh 'sudo snap remove golangci-lint || true'
            // Install GolangCI-lint
            sh 'go install github.com/golangci/golangci-lint/cmd/golangci-lint@latest'
            // Add $HOME/go/bin to PATH
            env.PATH += ":$HOME/go/bin"
        }
    }
}
