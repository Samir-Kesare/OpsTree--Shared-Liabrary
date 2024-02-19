package org.avengers.template.genericCi

import org.avengers.common.*
import org.avengers.credScanning.*

def call(Map config = [:], String gitLeaksVersion, String reportName){
  gitClone = new gitCheckout()
  gitLeaks = new GitLeaks()
  scan = new Scan()
  cleanAfterArchive = new CleanAfterArchive()

  try {
    gitclone.call(branch: config.branch, url: config.url  )
    gitLeaks.call(gitLeaksVersion)
    scan.call(reportName)
    } catch (Exception e) {
        echo "Check your code for credential Leak: ${e.message}"
    } finally {
       cleanAfterArchive.call(reportName) 
    }
  
}
