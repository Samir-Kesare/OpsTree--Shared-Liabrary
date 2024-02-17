package org.avengers.template.java

import org.avengers.common.*
import org.avengers.common.GitCheckoutPrivate
// import org.avengers.common.cleanWorkspace
// import org.avengers.java.dependencyCheck.dpCheck


def call(String url, String creds, String branch){
    def gitCheckout = new GitCheckoutPrivate()
    def packageArtifacts = new packageArtifacts()
    // def dpCheck = new dpCheck()
    // def cleanW = new cleanWorkspace()
  
    try {
        // Clone repository 
        gitCheckout.call(url, creds, branch)

        println("Before calling packageArtifacts function")
        // Package artifacts
        packageArtifacts.call()
        println("After calling packageArtifacts function")
      
        // perform Dependency Scanning 
        // dpCheck.call()
      
    } catch (e) {
        echo 'DP check Failed !'

        // clean workspace 
        // cleanW.call()
  
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
