package org.avengers.template.genericCi

import org.avengers.common.*
import org.avengers.licenseScanning.*

def call(Map config = [:]){
  gitClone = new gitCheckout()
  fossa = new Fossa()
  scan = new Scan()
  cleanAfterArchive = new package org.avengers.template.genericCi

import org.avengers.common.*
import org.avengers.credScanning.*

def call(Map config = [:], String gitLeaksVersion, String reportName){
  gitClone = new gitCheckout()
  gitLeaks = new GitLeaks()
  scan = new Scan()
  cleanAfterArchive = new CleanAfterArchive()

  try {
    gitClone.call(branch: config.branch, url: config.url  )
    gitLeaks.call(gitLeaksVersion)
    scan.call(reportName)
    } catch (Exception e) {
        echo "Check your code for credential Leak: ${e.message}"
    } finally {
       cleanAfterArchive.call(reportName) 
    }
  
}()

  try {
    gitClone.call(branch: config.branch, url: config.url  )
    gitLeaks.call(gitLeaksVersion)
    scan.call(reportName)
    } catch (Exception e) {
        echo "Check your code for credential Leak: ${e.message}"
    } finally {
       cleanAfterArchive.call(reportName) 
    }
  
}
