package org.avengers.template.Attandance_CI

import org.avengers.python.BugsAnalysis.*
import org.avengers.python.unitTesting.*
import org.avengers.python.dependencyScanning.*
import org.avengers.python.staticCodeAnalysis.*
import org.avengers.common.*

def call(String url, String creds, String branch, String depVersion, String javaVersion) {
    // Common definition
    def gitCheckoutPrivate = new GitCheckoutPrivate()
    def cleanW = new CleanWorkspace()
    def javaDownload = new JavaDownload()

    // Static code analysis definition
    def virtualEnv = new VirtualEnv()
    def dependencies = new Dependencies()
    def staticCodeAnalysis = new StaticCodeAnalysis()
    def archive = new ArchiveArtifacts()

    // Bugs analysis definition
    def bugsAnalysisBandit = new BugsAnalysisBandit()
    def installDependencies = new InstallDependencies()

    // Unit testing definition
    def installDependency = new InstallDependency()
    def unitTest = new Testing()

    // Dependency scanning definition
    def downloadDependencyCheck = new DownloadDependencyCheck()
    def dependencyCheck = new DependencyCheck()
    def cleanDp = new Clean()

    try {
        // Static code analysis
        gitCheckoutPrivate.call(url, creds, branch)
        virtualEnv.call()
        dependencies.call()
        staticCodeAnalysis.call()
    } catch (Exception e) {
        // Handle any exceptions during static code analysis
        echo "An error occurred during static code analysis: ${e.message}"
    } finally {
        archive.call()
    }

    // Bugs analysis
    bugsAnalysisBandit.call()
    installDependencies.call()

    // Unit Testing
    installDependency.call()
    unitTest.call()

    // Dependency scanning
    javaDownload.call(javaVersion)
    downloadDependencyCheck.call(depVersion)
    gitCheckoutPrivate.call(url, creds, branch)
    dependencyCheck.call()
    cleanDp.call()
}
