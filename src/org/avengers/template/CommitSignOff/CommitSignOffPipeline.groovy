package org.avengers.template.CommitSignOff

import org.avengers.CommitSignOff.GitCommitSignOff

def call(){
    def gitCommitSignOff = new GitCommitSignOff()


    gitCommitSignOff.signOffCommit("gitCommitPlaceholder", "gitCommitMsgPlaceholder")
}
