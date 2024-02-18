package org.avengers.template.python

import org.avengers.common.*
import org.avengers.python.staticCodeAnalysis.*

def call(String url, String creds, String branch){
  
  gitCheckoutPrivate = new GitCheckoutPrivate()
  virtual = new virtualEnv()
  dep = new dependencies()
  code = new staticCodeAnalysis()
  arch = new ArchiveArtifacts() 
  
  gitCheckoutPrivate.call(url, creds, branch)
  virtual.call()
  dep.call()
  code.call()
  arch.call()
  
}
 
