package org.avengers.template.python

import org.avengers.common.*
import org.avengers.python.BugsAnalysis.*

def call(String url, String creds, String branch){
  gitCheckoutPrivate = new GitCheckoutPrivate()
  cleanWorkspace = new cleanWorkspace()
  bugsAnalysisBandit = new BugsAnalysisBandit()
  installDependencies = new InstallDependencies()

  gitCheckoutPrivate.call(url, creds, branch)
  cleanWorkspace.call()
  bugsAnalysisBandit.call()
  installDependencies.call()
}
