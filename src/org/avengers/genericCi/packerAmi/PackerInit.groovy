package org.avengers.genericCi.packerAmi

def call() {
    // Change to the directory containing the Packer configuration
                    dir('/home/shreya/') {
                        // Initialize Packer (if necessary)
                        sh '/usr/bin/packer init .'
    }
}
