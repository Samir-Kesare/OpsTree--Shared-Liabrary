package org.avengers.template.ansibleRole_CD

import org.avengers.common.*
import org.avengers.ansibleRole_CD.*

// def call(String url, String creds, String branch, String gitleaksVersion, String tagVersion, String path, String gitpath){
def call(String url, String creds, String branch, String tagVersion, String path, String gitpath){
 
  gitCheckoutPrivate = new GitCheckoutPrivate()
  credentialscan = new Credentialscan()
  ansiblelint = new Ansiblelint()
  syntaxcheck = new Syntaxcheck()
  dryRun = new DryRun()
  gitTag = new gitTag()
  gitPushTag = new gitPushTag()

  gitCheckoutPrivate.call(url, creds, branch)
  ansiblelint.call(path)
  credentialscan.call()
  syntaxcheck.call(path)
  dryRun.call(path)
  gitTag.call(tagVersion)
  gitPushTag.call(gitpath, creds, tagVersion)
 
}
