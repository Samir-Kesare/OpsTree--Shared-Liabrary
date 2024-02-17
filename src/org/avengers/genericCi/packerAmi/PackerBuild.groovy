package org.avengers.genericCi.packerAmi

def call() {
    // Change to the directory containing the Packer configuration
    dir('/home/shreya/') {
        // Initialize Packer (if necessary)
        sh '''
            withCredentials([[
                $class: 'AmazonWebServicesCredentialsBinding',
                credentialsId: 'aws-credentials-id',
                accessKeyVariable: 'AWS_ACCESS_KEY_ID',
                secretKeyVariable: 'AWS_SECRET_ACCESS_KEY'
            ]]) {
                /usr/bin/packer build .
            '''
    }
}

