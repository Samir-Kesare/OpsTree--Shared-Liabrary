package org.avengers.genericCi.slackNotification

def call(buildStatus) {
    if (buildStatus == 'FAILURE') {
        slackSend channel: 'jenkinss', message: 'Job Build successfully'
    } else {
        slackSend channel: 'jenkinss', message: 'Job Failed'
    }
}

