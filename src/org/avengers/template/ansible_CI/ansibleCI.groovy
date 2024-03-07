package org.avengers.template.ansible_CI

import org.avengers.common.*
import org.avengers.ansible_CI.*

def call(String url, String creds, String branch, String gitleaksVersion, String tagVersion, String path){
  gitCheckoutPrivate = new GitCheckoutPrivate()
  credentialscan = new Credentialscan()
  ansiblelint = new Ansiblelint()
  syntaxcheck = new Syntaxcheck()
  gitTag = new gitTag()

  gitCheckoutPrivate.call(url, creds, branch)
  ansiblelint.call(path)
  credentialscan.call(gitleaksVersion)
  syntaxcheck.call(path)
  gitTag.call(tagVersion)
}


