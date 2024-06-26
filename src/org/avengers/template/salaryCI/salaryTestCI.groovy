package org.avengers.template

import org.avengers.credScanning.*
import org.avengers.common.*
import org.avengers.java.compile.*
import org.avengers.java.staticCodeAnalysis.*


def call(Map config = [:], String gitLeaksVersion, String reportName, String organization, String projectKey){
    
    def gitCheckout = new gitCheckout()
    def gitLeaks = new GitLeaks()
    def  scan = new Scan()
    def javaCompile = new compile()
    def sonarCloud = new sonarCloud()
    // def cleanWorkspace = new cleanWorkspace()
    // cleanAfterArchive = new CleanAfterArchive()
    
    try{
    gitCheckout.call(branch: config.branch, url: config.url  )
    gitLeaks.call(gitLeaksVersion)
    scan.call(reportName)
    javaCompile.call()
    sonarCloud.call(organization, projectKey)        
    }
    catch (e){
        echo 'Salary CI Failed'
        // cleanWorkspace.call()
        throw e
    }
    finally {
         def currentResult = currentBuild.result ?: 'SUCCESS'
        if ((currentResult == 'UNSTABLE')||(currentResult == 'ABORTED')) {
        // cleanWorkspace.call()
        echo 'This will run only if the run was marked as unstable'
        }
        // cleanAfterArchive.call(reportName) 
    }
}
