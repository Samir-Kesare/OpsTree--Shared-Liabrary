pipeline {
    agent any
    
    stages {
        stage('Fetch Last Commit') {
            steps {
                script {
                    checkout scm
                    
                    def gitCommit = sh(script: 'git log -1 --pretty=%an', returnStdout: true).trim()
                    def gitCommitMsg = sh(script: 'git log -1 --pretty=%B', returnStdout: true).trim()
                    
                    // Perform commit sign-off logic here
                    // For example:
                    echo "Last commit author: ${gitCommit}"
                    echo "Last commit message: ${gitCommitMsg}"
                }
            }
        }
    }
}
