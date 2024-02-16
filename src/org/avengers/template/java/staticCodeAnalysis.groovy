package org.avengers.template

import org.avengers.common.gitCheckout
import org.avengers.common.cleanWorkspace
import org.avengers.java.*

def call(Map config = [:]){
    def gitCheckout = new gitCheckout()
    def javaCompile = new compile()
    def cleanWorkspace = new cleanWorkspace()
    def staticCodeAnalysis = new staticCodeAnalysis()
    try{
    gitCheckout.call(branch: config.branch, url: config.url  )
    javaCompile.call()
    staticCodeAnalysis.call()
    }
    // gitCheckout.call(branch: config.branch, url: config.url  )
    // javaCompile.call()
    catch (e) {
        echo 'Analysis Failed'
        cleanWorkspace.call()
        // Since we're catching the exception in order to report on it,
        // we need to re-throw it, to ensure that the build is marked as failed
        throw e
    } 
    finally {
         def currentResult = currentBuild.result ?: 'SUCCESS'
        if ((currentResult == 'UNSTABLE')||(currentResult == 'ABORTED')) {
        cleanWorkspace.call()
            // echo 'This will run only if the run was marked as unstable'
    }
  }
}
