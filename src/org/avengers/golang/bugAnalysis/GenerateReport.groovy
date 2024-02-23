package org.avengers.golang.bugAnalysis

def call() {
    stage('Generate HTML Report') {
        script {
             // Run golangci-lint with the --out-format option to specify the output format
             sh 'golangci-lint run ./... --out-format html > report.html || true'
        }
    }
}
