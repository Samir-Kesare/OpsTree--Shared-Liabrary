def call() {
    stage('Publish HTML Report') {
        steps {
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/site',
                reportFiles: 'spotbugs.html',
                reportName: 'SpotBugs Report'
            ])
        }
    }
}
