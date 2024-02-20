package org.avengers.template.CommitSignOff

import org.avengers.CommitSignOff.*
import org.avengers.common.*

def call(){
    gitCommit = new GitCommit()
    gitCheckoutPrivate = new GitCheckoutPrivate()

    gitCommit.call()
    gitCheckoutPrivate.call(url, creds, branch)
}
