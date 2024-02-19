package org.avengers.template.CommitSignOff

import org.avengers.CommitSignOff.*

def call(){
    def gitCommitSignOff = new GitCommitSignOff()


    gitCommitSignOff.call(gitCommit, gitCommitMsg)
}
