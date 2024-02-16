package org.avengers.genericCi.slackNotification

def call() {
    post {
        success { 
            slackNotification("SUCCESS")
            echo 'Compiled Successfully !'
        }
        failure { 
            slackNotification("FAILURE")
            echo 'Compilation Failed !'
        }
    }
}

