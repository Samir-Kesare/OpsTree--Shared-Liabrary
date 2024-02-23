package org.avengers.template

import org.avengers.licenseScanning.licenceScan
import org.avengers.credScanning.*
import org.avengers.common.*
import org.avengers.java.compile.*
import org.avengers.java.staticCodeAnalysis.*
import org.avengers.java.dependencyCheck.*
import org.avengers.java.unitTesting.*
import org.avengers.java.bugAnalysis.*


def call(Map config = [:], String gitLeaksVersion, String reportName){
    
    def licenceScan = new licenceScan()
    def gitCheckout = new gitCheckout()
    def javaCompile = new compile()
    def staticCodeAnalysis = new staticCodeAnalysis()
    def cleanWorkspace = new cleanWorkspace()
    def dpCheck = new dpCheck()
    def javaUnitTesting = new test()
    def javaBugAnalysis = new bug()
    def javaPublishHtml = new publishHtml()
    def gitLeaks = new GitLeaks()
    def  scan = new Scan()
    cleanAfterArchive = new CleanAfterArchive()
    
    try{
    gitCheckout.call(branch: config.branch, url: config.url  )
    gitLeaks.call(gitLeaksVersion)
    scan.call(reportName)
    withCredentials([string(credentialsId: 'fossaToken', variable: 'FOSSA_API_KEY')]){
        licenceScan.installFossa()
        licenceScan.scan()
    }
    javaCompile.call()
    parallel dpCheck: {
        dpCheck.call()
    },
    staticCodeAnalysis: {
        staticCodeAnalysis.call()        
    },
    bugAnalysis: {
        javaBugAnalysis.call()
        javaPublishHtml.call()
    },
    unitTesting:{
        javaUnitTesting.call()   
    }
    }
    catch (e){
        echo 'Salary CI Failed'
        cleanWorkspace.call()
        throw e
    }
    finally {
         def currentResult = currentBuild.result ?: 'SUCCESS'
        if ((currentResult == 'UNSTABLE')||(currentResult == 'ABORTED')) {
        cleanWorkspace.call()
            // echo 'This will run only if the run was marked as unstable'
        }
        // cleanAfterArchive.call(reportName) 

    }
}
