def call() {
    script {
        def gitCommit = sh(script: 'git log -1 --pretty=%an', returnStdout: true).trim()
        def gitCommitMsg = sh(script: 'git log -1 --pretty=%B', returnStdout: true).trim()
        
        // Check if commit sign-off is present
        if (gitCommitMsg.contains('Signed-off-by:')) {
            echo "Last commit by ${gitCommit} has a sign-off."
        } else {
            // Iterate through usernames and find matching email and name
            def usernameEmailMap = [
                'vikram445': 'vikram.bisht@opstree.com',
                'aakashtripathi-snaatak': 'aakash.tripathi.snaatak@mygurukulam.co',
                'vyadavP7': 'vidhi.yadhav.snaatak@mygurukulam.co',
                'code-shantanu': 'shantanu.chauhan.snaatak@mygurukulam.co',
                'Vishalkk1998': 'vishal.kesarwani.snaatak@mygurukulam.co',
                'Panu-S-Harshit-Ninja-07': 'harshit.singh.snaatak@mygurukulam.co',
                'khushimalhoz': 'khushi.malhotra.snaatak@mygurukulam.co',
                'Snatak-SamirKesare': 'samir.kesare.snaatak@mygurukulam.co',
                'Parasharam-Desai': 'parasharam.desai.snaatak@mygurukulam.co',
                'tripathishikha1': 'shikha.tripathi.snaatak@mygurukulam.co',
                'shreya-snaatak': 'shikha.tripathi.snaatak@mygurukulam.co',
                'Nidhi-bhardwaj123': 'nidhi.bhardwaj.snaatak@mygurukulam.co'
            ]
            
            def email = usernameEmailMap[gitCommit]
            
            if (email) {
                sh "git commit --amend --signoff --author='${gitCommit} <${email}>' -m '${gitCommitMsg} Signed-off-by: ${email}'"
                echo "Commit message updated with sign-off by ${gitCommit}."
            } else {
                error "Unable to find email for ${gitCommit}."
            }
        }
    }
}
