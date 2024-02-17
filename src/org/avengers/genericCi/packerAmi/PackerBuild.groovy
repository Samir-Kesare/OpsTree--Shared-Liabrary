package org.avengers.genericCi.packerAmi

def call() {
    dir('/home/shreya/') {
        withCredentials([[
            $class: 'AmazonWebServicesCredentialsBinding',
            credentialsId: 'aws creds',
            accessKeyVariable: 'AWS_ACCESS_KEY_ID',
            secretKeyVariable: 'AWS_SECRET_ACCESS_KEY'
        ]]) {
            sh '/usr/bin/packer build .'
        }
    }
}

