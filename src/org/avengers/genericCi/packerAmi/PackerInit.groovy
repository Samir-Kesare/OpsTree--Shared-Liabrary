package org.avengers.genericCi.packerAmi

def call() {
    dir('/home/shreya/') {
        sh '/usr/bin/packer init .'
    }
}
