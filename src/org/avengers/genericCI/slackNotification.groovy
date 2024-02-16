package org.avengers.genericCI

def call() {
    stage('Send Slack Notification') {
        script {
            if (status == 'SUCCESS') {
                slackSend(channel: 'jenkinss', color: '#00FF00', message: 'Job Build successfully')
            }
            if (status == 'FAILURE') {
                slackSend(channel: 'jenkinss', color: '#FF0000', message: 'Job Failed')
            }
        }
    }
}
