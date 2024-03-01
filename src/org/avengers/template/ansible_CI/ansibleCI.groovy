package org.avengers.template.ansible_CI

import org.avengers.common.*
import org.avengers.golang.ansible_CI.*

def call(String url, String creds, String branch, String gitleaksVersion, String tagVersion){
  gitCheckoutPrivate = new GitCheckoutPrivate()
  ansiblelint = new Ansiblelint()
  credentialscan = new Credentialscan()
  syntaxcheck = new Syntaxcheck()
  gitTag = new gitTag(tagVersion)

  gitCheckoutPrivate.call(url, creds, branch)
  ansiblelint.call()
  credentialscan.call(gitleaksVersion)
  syntaxcheck.call()
  gitTag.call(tagVersion)
}


