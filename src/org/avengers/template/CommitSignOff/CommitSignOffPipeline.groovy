package org.avengers.template

import org.avengers.CommitSignOff.*

class CommitSignOffPipeline {
    static void performCommitSignOff() {
        node {
            stage('Fetch Last Commit') {
                checkout scm
                
                def gitCommit = sh(script: 'git log -1 --pretty=%an', returnStdout: true).trim()
                def gitCommitMsg = sh(script: 'git log -1 --pretty=%B', returnStdout: true).trim()
                
                // Check if commit sign-off is present
                if (gitCommitMsg.contains('Signed-off-by:')) {
                    echo "Last commit by ${gitCommit} has a sign-off."
                } else {
                    GitCommitSignOff.signOffCommit(gitCommit, gitCommitMsg)
                }
            }
        }
    }
}


