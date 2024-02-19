package org.avengers.template.golang


import org.avengers.common.*
import org.avengers.golang.CodeCompilation.*

def call(String url, String creds, String branch){
  cleanWorkspace = new cleanWorkspace()
  gitCheckoutPrivate = new GitCheckoutPrivate()
  installationgo = new installationgo()
  codecompilation = new codecompilation()

  cleanWorkspace.call()
  gitCheckoutPrivate.call(url, creds, branch)
  installationgo.call()
  codecompilation.call()
}
  
