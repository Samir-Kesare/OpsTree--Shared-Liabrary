package org.avengers.genericCi.slackNotification

def call() {
    post {
        success {
            slackSend channel: 'jenkinss', message: 'Job Build successfully'
        }
        failure {
            slackSend channel: 'jenkinss', message: 'Job Failed '
        }
    }
}

