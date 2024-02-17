package org.avengers.genericCi.packerAmi

def call() {
    // Change to the directory containing the Packer configuration
    dir('/home/shreya/') {
        // Build the AMI
        sh '/usr/bin/packer build .'
    }
}

