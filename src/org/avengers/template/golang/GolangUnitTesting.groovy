package org.avengers.template

import org.avengers.common.*
import org.avengers.golang.unitTesting.*

def call(String url, String creds, String branch){
  installGo = new InstallGo()
  gitCheckoutPrivate = new GitCheckoutPrivate()
  testing = new Testing()
  report = new Report()

  installGo.call()
  gitCheckoutPrivate.call(url, creds, branch)
  testing.call()
  report.call()
}
  
