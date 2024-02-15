def call() {
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/site',
                reportFiles: 'spotbugs.html',
                reportName: 'SpotBugs Report'
            ])
}
