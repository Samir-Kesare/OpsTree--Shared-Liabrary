post {
        always {
            // Archive pylint reports
            archiveArtifacts artifacts: '**/pylint.log', allowEmptyArchive: true
        }
    }
}
