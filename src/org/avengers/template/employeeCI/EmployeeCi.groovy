package org.avengers.template.employeeCI

import org.avengers.licenseScanning.licenceScan
import org.avengers.credScanning.*
import org.avengers.common.*
import org.avengers.golang.CodeCompilation.*
import org.avengers.golang.GoLangDependencyScanning.*
import org.avengers.golang.bugAnalysis.*
import org.avengers.golang.unitTesting.*

def call(Map config = [:], String gitLeaksVersion, String reportName, String depVersion){

    def licenceScan = new licenceScan()
    def gitCheckout = new gitCheckout()
    def gitLeaks = new GitLeaks()
    def scan = new Scan()
    def compile = new codecompilation() 
    def installGo = new InstallationPreRequisites()
    def bugAnalysis = new Linting()
    def generateReport = new GenerateReport()
    def downloadDepCheck = new DownloadDependencyCheck()
    def depCheck = new DependencyCheck()
    def unitTesting = new Testing()
    def cleanWorkspace = new cleanWorkspace()

    try{
    gitCheckout.call(branch: config.branch, url: config.url  )
    installGo.call()    
    gitLeaks.call(gitLeaksVersion)
    scan.call(reportName)
    withCredentials([string(credentialsId: 'fossaToken', variable: 'FOSSA_API_KEY')]){
        licenceScan.installFossa()
        licenceScan.scan()
    }
    compile.call()
    parallel depCheck: {
        downloadDepCheck.call(depVersion)
        depCheck.call()
    },
    bugAnalysis: {
        bugAnalysis.call()
    },
    unitTesting:{
        unitTesting.call()   
    }
    generateReport.call()
    }
    catch (e){
        echo 'Emplyoee CI Failed'
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
