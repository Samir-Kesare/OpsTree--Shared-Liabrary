package org.avengers.template.CommitSignOff

import org.avengers.common.*
import org.avengers.CommitSignOff.*
    def call(String url, String creds, String branch){
        gitCheckoutPrivate = new GitCheckoutPrivate()
        gitcommitsignoff = new GitCommitSignOff()

         gitCheckoutPrivate.call()
        gitcommitsignoff.call()
    }





