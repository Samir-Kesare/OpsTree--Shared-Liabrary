package org.avengers.template.java

import org.avengers.common.*
import org.avengers.java.dependencyCheck.dpCheck


def call(String url, String creds, String branch){

    def gitCheckout = new GitCheckoutPrivate()
    def dpCheck = new dpCheck()
    def cleanW = new cleanWorkspace()
  
    try {
        // Clone repository 
        gitCheckout.call(url, creds, branch)
        
        // perform Dependency Scanning 
        dpCheck.call()
      
    } catch (e) {
        echo 'DP check Failed !'

        // clean workspace 
        cleanW.call()
  
        throw e
    } finally {
     //   echo "In finally block"
      //  echo "Current build result: ${currentBuild.currentResult}"
        
        if (currentBuild.currentResult == 'SUCCESS') {
            echo 'DP check Successful!'

            // archive HTML reports as artifacts
            archiveArtifacts artifacts: '**/dependency-check-report.html'

            // show workspace in tree structure
            sh 'tree ${WORKSPACE}'
        }
    }
}
