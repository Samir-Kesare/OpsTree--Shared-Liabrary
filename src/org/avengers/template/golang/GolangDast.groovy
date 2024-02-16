package org.avengers.template.golang

import org.avengers.common.*
import org.avengers.golang.dast.*

def call(String url, String creds, String branch, String zapVersion){
  gitCheckoutPrivate = new GitCheckoutPrivate()
  OwaspZapInstallation = new OwaspZapInstallation()
  RunZap = new RunZap()

  gitCheckoutPrivate.call(url, creds, branch)
  OwaspZapInstallation.call(zapVersion)
  RunZap.call(zapVersion)
}
