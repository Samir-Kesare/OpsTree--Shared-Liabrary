package org.avengers.python.staticCodeAnalysis

def call() {
    post {
        always {
            // Archive pylint reports
            archiveArtifacts artifacts: '**/pylint.log', allowEmptyArchive: true
        }
    }
}
