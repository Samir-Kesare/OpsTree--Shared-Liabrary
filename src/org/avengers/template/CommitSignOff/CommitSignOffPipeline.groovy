package org.avengers.template.CommitSignOff

import org.avengers.CommitSignOff.GitCommitSignOff

def call(String url, String creds, String branch){
    def gitCheckoutPrivate = new GitCheckoutPrivate()
    def gitCommitSignOff = new GitCommitSignOff()

    gitCheckoutPrivate.call() 
    gitCommitSignOff.signOffCommit("gitCommitPlaceholder", "gitCommitMsgPlaceholder")
}
