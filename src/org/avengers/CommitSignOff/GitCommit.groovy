package org.avengers.CommitSignOff

def call() {
    stage('Fetch Last Commit') {
           checkout scm // This line will check out the source code from the configured Git repository
            script {
                def gitCommit = sh(script: 'git log -1 --pretty=%an', returnStdout: true).trim()
                def gitCommitMsg = sh(script: 'git log -1 --pretty=%B', returnStdout: true).trim()
                
                // Check if commit sign-off is present
                if (gitCommitMsg.contains('Signed-off-by:')) {
                    echo "Last commit by ${gitCommit} has a sign-off."
                } else {
                    // Check if there are changes to commit
                    try {
                       // sh 'ls -al'
                        sh 'git diff --exit-code'
                        // No exception means there are no changes
                        echo "No changes to commit."
                        echo "${gitCommitMsg}"
                        echo "${gitCommit}"
                        // Exception indicates there are changes
                        // Add and commit changes
                       // sh 'git add .'
                        //sh "git commit -m 'Auto-commit before sign-off'"
                        
                        // Iterate through usernames and find matching email and name
                       // echo "hello if 1"
                        def usernameEmailMap = [
                            'vikram445': 'vikram.bisht@opstree.com',
                            'aakashtripathi-snaatak': 'aakash.tripathi.snaatak@mygurukulam.co',
                            'vyadavP7': 'vidhi.yadhav.snaatak@mygurukulam.co',
                            'code-shantanu': 'shantanu.chauhan.snaatak@mygurukulam.co',
                            'Vishalkk1998': 'vishal.kesarwani.snaatak@mygurukulam.co',
                            'Panu-S-Harshit-Ninja-07': 'harshit.singh.snaatak@mygurukulam.co',
                            'Khushi Malhotra': 'khushi.malhotra.snaatak@mygurukulam.co',
                            'Snatak-SamirKesare': 'samir.kesare.snaatak@mygurukulam.co',
                            'Parasharam-Desai': 'parasharam.desai.snaatak@mygurukulam.co',
                            'tripathishikha1': 'shikha.tripathi.snaatak@mygurukulam.co',
                            'shreya-snaatak': 'shreya.jaiswal.snaatak@mygurukulam.co',
                            'Nidhi-bhardwaj123': 'nidhi.bhardwaj.snaatak@mygurukulam.co'
                
                        ]   
                        def email = usernameEmailMap[gitCommit] 
                        //echo "hello if 2"
                        echo "${email}"
                        if (email) {
                            def newCommitMsg = "${gitCommitMsg}\nSigned-off-by: ${email}"
                            //echo "hello if 3"
                            sh "git commit --amend --signoff -m '${newCommitMsg}'"
                            echo "New commit message updated with sign-off by ${gitCommit}."
                        } else {
                            error "Unable to find email for ${gitCommit}."
                        }
                    }
                catch (Exception e) {
                    echo "ERROR"
                }
            }
        }
    }
}
