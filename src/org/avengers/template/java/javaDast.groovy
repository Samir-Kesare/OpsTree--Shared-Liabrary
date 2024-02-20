package org.avengers.template.java

import org.avengers.common.*
import org.avengers.java.dast.*

def call(String url, String creds, String branch, String zapVersion, String currentWorkspace){
  gitCheckoutPrivate = new GitCheckoutPrivate()
  owaspZapInstallation = new OwaspZapInstallation()
  runZap = new RunZap()

  gitCheckoutPrivate.call(url, creds, branch)
  owaspZapInstallation.call(zapVersion)
  runZap.call(zapVersion, currentWorkspace)

  archiveArtifacts artifacts: '**/results.html', allowEmptyArchive: true
}
