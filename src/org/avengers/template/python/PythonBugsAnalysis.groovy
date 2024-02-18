package org.avengers.template.python

import org.avengers.common.*
import org.avengers.python.BugsAnalysis.*

def call(String url, String creds, String branch){
  gitCheckoutPrivate = new GitCheckoutPrivate()
  cleanWorkspace = new cleanWorkspace()
  bugsAnalysis-Bandit = new BugsAnalysis-Bandit()
  installDependencies = new InstallDependencies()

  gitCheckoutPrivate.call(url, creds, branch)
  cleanWorkspace.call()
  bugsAnalysis-Bandit.call()
  installDependencies.call()
}
