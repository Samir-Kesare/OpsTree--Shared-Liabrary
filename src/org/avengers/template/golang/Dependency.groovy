package org.avengers.template.golang

import org.avengers.common.*
import org.avengers.python.dependencyScanning.*

def call(String url, String creds, String branch, String depVersion, String javaVersion){
  javaDownload = new JavaDownload()
  downloadDependencyCheck = new DownloadDependencyCheck()
  gitCheckoutPrivate = new GitCheckoutPrivate()
  dependencyCheck = new DependencyCheck()
  clean = new Clean()

  javaDownload.call(javaVersion)
  downloadDependencyCheck.call(depVersion) 
  gitCheckoutPrivate.call(url, creds, branch)
  dependencyCheck.call(depreport)
  clean.call()
}
  
