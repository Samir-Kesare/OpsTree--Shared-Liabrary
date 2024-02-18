package org.avengers.template.golang

import org.avengers.common.*
import org.avengers.golang.CodeCompilation.*

def call(String url, String creds, String branch){
  gitCheckoutPrivate = new GitCheckoutPrivate()
  installationPreRequisites = new InstallationPreRequisites()
  codecompilation = new codecompilation()

  
  gitCheckoutPrivate.call(url, creds, branch)
  installationPreRequisites.call()
  codecompilation.call()
}
  
