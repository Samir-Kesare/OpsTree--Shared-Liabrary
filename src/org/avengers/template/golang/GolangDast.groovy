package org.avengers.template.golang

import org.avengers.common.*
import org.avengers.golang.dast.*

def call(String url, String creds, String branch, String zapVersion){
  gitCheckoutPrivate = new GitCheckoutPrivate()
  owaspZapInstallation = new OwaspZapInstallation()
  runZap = new RunZap()

  gitCheckoutPrivate.call(url, creds, branch)
  owaspZapInstallation.call(zapVersion)
  runZap.call(zapVersion)
}
