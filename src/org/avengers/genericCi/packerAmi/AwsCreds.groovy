package org.avengers.genericCi.packerAmi

def call() {
     // Define AWS credentials
    withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws creds', accessKeyVariable: 'AWS_ACCESS_KEY_ID', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']])
    }
