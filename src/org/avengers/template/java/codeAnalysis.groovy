package org.avengers.template

import org.avengers.common.gitCheckout
import org.avengers.common.cleanWorkspace
import org.avengers.java.compile.*
import org.avengers.java.staticCodeAnalysis.*

def call(Map config = [:]){
    def gitCheckout = new gitCheckout()
    def javaCompile = new compile()
    def staticCodeAnalysis = new staticCodeAnalysis()
    def cleanWorkspace = new cleanWorkspace()
    try{
    gitCheckout.call(branch: config.branch, url: config.url  )
    javaCompile.call()
    staticCodeAnalysis.call()
    }
    catch (e){
        echo 'Analysis Failed'
        cleanWorkspace.call()
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
