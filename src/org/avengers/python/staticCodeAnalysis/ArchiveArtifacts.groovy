package org.avengers.python.staticCodeAnalysis
def call() {
    post {
        always {
            try {
                // Archive pylint reports
                archiveArtifacts artifacts: '**/pylint.log', allowEmptyArchive: true
            } catch (Exception e) {
                // Handle any exception that occurs during archiving
                echo "An error occurred while archiving pylint reports: ${e.message}"
            }
        }
    }
}
