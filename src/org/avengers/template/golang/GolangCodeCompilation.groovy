package org.avengers.template.golang


import org.avengers.common.*
import org.avengers.golang.CodeCompilation.*

def call(String url, String creds, String branch){
  gitCheckoutPrivate = new GitCheckoutPrivate()
  installationgo = new installationgo()
  codecompilation = new codecompilation()

  
  gitCheckoutPrivate.call(url, creds, branch)
  installationgo.call()
  codecompilation.call()
}
  
