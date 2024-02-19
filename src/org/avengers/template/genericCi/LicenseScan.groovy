package org.avengers.template.genericCi

import org.avengers.common.*
import org.avengers.licenseScanning.*

def call(Map config = [:]){
  gitClone = new gitCheckout()
  fossa = new Fossa()
  scan = new Scan()
  cleanworkspace = new CleanWorkSpace()

  try {
    gitClone.call(branch: config.branch, url: config.url  )
    fossa.call()
    scan.call()
    } catch (Exception e) {
        echo "Check your code for License Issues: ${e.message}"
    } finally {
       cleanworkspace.call() 
    }
  
}
