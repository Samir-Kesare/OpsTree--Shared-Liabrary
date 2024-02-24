package org.avengers.template.employeeCI

import org.avengers.licenseScanning.licenceScan
import org.avengers.credScanning.*
import org.avengers.common.*
import org.avengers.golang.CodeCompilation.*
import org.avengers.golang.GoLangDependencyScanning.*
import org.avengers.golang.bugAnalysis.*
import org.avengers.golang.unitTesting.*
import org.avengers.golang.StaticAnalysis.*
    
def call(Map config = [:], String gitLeaksVersion, String depVersion, String javaVersion, String gitLeaksReport, String uniTestReport, String BugAnalysisreport, String depreport) {

    def licenceScanner = new licenceScan()
    def gitCheckout = new gitCheckout()
    def gitLeaks = new GitLeaks()
    def compile = new codecompilation() 
    def installGo = new InstallationPreRequisites()
    def bugAnalysis = new Linting()
    def generateReport = new GenerateReport()
    def downloadDepCheck = new DownloadDependencyCheck()
    def depCheck = new DependencyCheck()
    def unitTesting = new Testing()
    def javaDownload = new JavaDownload()
    def cleanForEmp =new CleanForEmp()
    def cleanWorkSpace =new CleanWorkSpace()
    def staticAnalysis = new gostaticanalysis()

    try{
    gitCheckout.call(branch: config.branch, url: config.url  )
    gitLeaks.call(gitLeaksVersion)
    withCredentials([string(credentialsId: 'fossaToken', variable: 'FOSSA_API_KEY')]){
        licenceScanner.installFossa()
        licenceScanner.scan()
    }
    installGo.call()
    javaDownload.call(javaVersion)
    downloadDepCheck.call(depVersion)
    compile.call()
    parallel depCheck: {
        depCheck.call(depreport)
    },
    staticAnalysis: {
        staticAnalysis.call()
    },
    bugAnalysis: {
        bugAnalysis.call()
    },
    unitTesting:{
        unitTesting.call()   
    }
    generateReport.call(gitLeaksReport, uniTestReport, BugAnalysisreport)
    }
    catch (e){
        echo 'Emplyoee CI Failed'
        cleanWorkSpace.call()
        throw e
    }
    finally {
        cleanForEmp.call(gitLeaksReport, uniTestReport, BugAnalysisreport, depreport)
        cleanWorkSpace.call()
    }
}
