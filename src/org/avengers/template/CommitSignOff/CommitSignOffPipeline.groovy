package org.avengers.template.CommitSignOff

import org.avengers.common.GitCheckoutPrivate 

class CommitSignOffPipeline {
    static void performCommitSignOff() {
        node {
            stage('Fetch Last Commit') {
                checkout scm
                
                def gitCommit = sh(script: 'git log -1 --pretty=%an', returnStdout: true).trim()
                def gitCommitMsg = sh(script: 'git log -1 --pretty=%B', returnStdout: true).trim()
                
                
                if (gitCommitMsg.contains('Signed-off-by:')) {
                    echo "Last commit by ${gitCommit} has a sign-off."
                } else {
                    GitCheckoutPrivate gitCheckoutPrivate = new GitCheckoutPrivate() 
                    gitCheckoutPrivate.call(url, creds, branch) 
                }
            }
        }
    }
}


