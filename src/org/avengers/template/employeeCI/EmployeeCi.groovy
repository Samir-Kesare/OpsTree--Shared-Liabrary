package org.avengers.template.employeeCI

import org.avengers.licenseScanning.*
import org.avengers.credScanning.*
import org.avengers.common.*
import org.avengers.golang.CodeCompilation.*
import org.avengers.golang.GoLangDependencyScanning.*
import org.avengers.golang.bugAnalysis.*
import org.avengers.golang.unitTesting.*

def call(Map config = [:], String gitLeaksVersion, String reportName, String depVersion, String javaVersion) {
    def licenceScanner = new licenceScan()
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
    def javaDownload = new JavaDownload()

    try {
        gitCheckout.branch(config.branch).url(config.url)
        installGo()
        javaDownload.javaVersion(javaVersion)
        downloadDepCheck.depVersion(depVersion)
        gitLeaks.gitLeaksVersion(gitLeaksVersion)
        scan.reportName(reportName)
        withCredentials([string(credentialsId: 'fossaToken', variable: 'FOSSA_API_KEY')]) {
            licenceScanner.installFossa()
            licenceScanner.scan()
        }
        compile()
        def results = [:]
        results.depCheck = { depCheck() }
        results.bugAnalysis = { bugAnalysis() }
        results.unitTesting = { unitTesting() }
        parallel results

        generateReport()
    } catch (e) {
        echo 'Employee CI Failed'
        cleanWorkspace()
        throw e
    } finally {
        def currentResult = currentBuild.result ?: 'SUCCESS'
        if (currentResult in ['UNSTABLE', 'ABORTED']) {
            cleanWorkspace()
            // echo 'This will run only if the run was marked as unstable'
        }
    }
}
