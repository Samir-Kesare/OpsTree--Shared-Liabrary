package org.avengers.template.ansible_CD

import org.avengers.common.*
import org.avengers.ansible_CD.*

def call(String url, String creds, String branch, String gitleaksVersion, String path){
  gitCheckoutPrivate = new GitCheckoutPrivate()
  credentialscan = new Credentialscan()
  ansiblelint = new Ansiblelint()
  syntaxcheck = new Syntaxcheck()
  dryRun = new DryRun()
  ansibleRun = new AnsibleRun()

  gitCheckoutPrivate.call(url, creds, branch)
  ansiblelint.call()
  credentialscan.call(gitleaksVersion)
  syntaxcheck.call()
  dryRun.call()
  ansibleRun.call(path)
}
