package org.avengers.template.CommitSignOff

import org.avengers.CommitSignOff.*

def call(){
    gitCommit = new GitCommit()


    gitCommit.call()
}
