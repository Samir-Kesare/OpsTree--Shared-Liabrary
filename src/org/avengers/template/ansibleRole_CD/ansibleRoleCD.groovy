package org.avengers.template.ansibleRole_CD

import org.avengers.common.*
import org.avengers.ansibleRole_CD.*

def call(String url, String creds, String branch, String gitleaksVersion, String tagVersion, String path){
  gitCheckoutPrivate = new GitCheckoutPrivate()
  credentialscan = new Credentialscan()
  ansiblelint = new Ansiblelint()
  syntaxcheck = new Syntaxcheck()
  dryRun = new DryRun()
  gitTag = new gitTag()
  gitPushTag = new gitPushTag()

  gitCheckoutPrivate.call(url, creds, branch)
  ansiblelint.call()
  credentialscan.call(gitleaksVersion)
  syntaxcheck.call()
  dryRun.call()
  gitPushTag.call(path)
 
}
