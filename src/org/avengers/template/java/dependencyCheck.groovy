package org.avengers.template.java

import org.avengers.common.GitCheckoutPrivate
import org.avengers.common.cleanWorkspace
import org.avengers.java.dependencyCheck.dpCheck
// import org.avengers.common.packageArtifacts

def call(Map config = [:]){
    def gitCheckout = new GitCheckoutPrivate()
    def dpCheck = new dpCheck()
    def cleanW = new cleanWorkspace()
  
    try {
        // Clone repository 
        gitCheckout.call(branch: config.branch, url: config.url, credentialsId: config.credentialsId)
      
        // Package artifacts
        // packageArtifacts.call()
      
        // perform Dependency Scanning 
        dpCheck.call()
      
    } catch (e) {
        echo 'DP check Failed !'

        // clean workspace 
        cleanW.call()
  
        throw e
    } finally {
        if (currentBuild.result == 'SUCCESS') {
            echo 'DP check Successful!'

            // archive HTML reports as artifacts
            archiveArtifacts artifacts: '**/dependency-check-report.html'

            // show workspace in tree structure
            sh 'tree ${WORKSPACE}'
        }
    }
}
