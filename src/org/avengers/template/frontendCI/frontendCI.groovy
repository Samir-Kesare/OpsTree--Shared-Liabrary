package org.avengers.template

import org.avengers.licenseScanning.licenceScan
import org.avengers.credScanning.*
import org.avengers.common.*


def call(Map config = [:], String gitLeaksVersion, String reportName){
    
    def licenceScan = new licenceScan()
    def gitCheckout = new gitCheckout()
    def cleanWorkspace = new cleanWorkspace()
    def gitLeaks = new GitLeaks()
    def  scan = new Scan()
    
    try{
    gitCheckout.call(branch: config.branch, url: config.url  )
    gitLeaks.call(gitLeaksVersion)
    scan.call(reportName)
    withCredentials([string(credentialsId: 'fossaToken', variable: 'FOSSA_API_KEY')]){
        licenceScan.installFossa()
        licenceScan.scan()
    }
    
    }
    catch (e){
        echo 'Frontend CI Failed'
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
