package org.avengers.template.golang


import org.avengers.common.*
import org.avengers.golang.StaticAnalysis.*
import org.avengers.golang.CodeCompilation.*

def call(String url, String branch){

  installationgo = new installationgo() 
  gitCheckoutPrivate = new GitCheckoutPrivate()
  gostaticanalysis = new gostaticanalysis()
   
  gitCheckoutPrivate.call(url, creds, branch)
  installationgo.call()
  gostaticanalysis.call()
}
