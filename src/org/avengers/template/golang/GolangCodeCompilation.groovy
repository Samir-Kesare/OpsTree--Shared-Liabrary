package org.avengers.template.golang

import org.avengers.common.*
import org.avengers.golang.CodeCompilation.*

def call(String url, String creds, String branch){
  codecompilation = new CodeCompilation
  gitCheckoutPrivate = new GitCheckoutPrivate()
  linting = new Linting()
  report = new Report()

  installationPreRequisites.call()
  gitCheckoutPrivate.call(url, creds, branch)
  linting.call()
  report.call()
}
  
