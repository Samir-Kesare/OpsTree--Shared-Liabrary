package org.avengers.template.golang

import org.avengers.common.*
import org.avengers.golang.CodeCompilation.*

def call(String url, String creds, String branch){
  gitCheckoutPrivate = new GitCheckoutPrivate()
  codecompilation = new codecompilation()

  
  gitCheckoutPrivate.call(url, creds, branch)
  codecompilation.call()
}
  
