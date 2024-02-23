package org.avengers.golang.bugAnalysis

def call() {
    stage('Generate HTML Report') {
        script {
             // Run golangci-lint with the --out-format option to specify the output format
             sh 'golangci-lint run ./... --out-format html > BugAnalysisreport.html || true'
             sh 'go test ./... -coverprofile=coverage.out || true'
             sh 'go tool cover -html=coverage.out -o coverage.html || true'
        }
    }
}
