package org.avengers.template

import org.avengers.python.BugsAnalysis.*
import org.avengers.python.dependencyScanning.*
import org.avengers.python.staticCodeAnalysis.*
import org.avengers.common.*  

def call(String url, String creds, String branch, String depVersion) {
    //common
    def gitCheckoutPrivate = new GitCheckoutPrivate()
    def cleanW = new cleanWorkspace()

    // Static code analysis
    def VirtualEnv = new virtualEnv()
    def Dependencies = new dependencies()
    def StaticCodeAnalysis = new staticCodeAnalysis()
    def archive = new ArchiveArtifacts() 

    // bugs analysis
    def bugsAnalysisBandit = new BugsAnalysisBandit()
    def installDependencies = new InstallDependencies()

    // dependency scanning
    def downloadDependencyCheck = new DownloadDependencyCheck()
    def dependencyCheck = new DependencyCheck()


    downloadDependencyCheck.call(depVersion) 
    gitCheckoutPrivate.call(url, creds, branch)
    dependencyCheck.call()
    clean.call()
    cleanW.call()
    bugsAnalysisBandit.call()
    installDependencies.call()
    
    try {
        virtual.call()
        dep.call()
        code.call()
    } catch (Exception e) {
        // Handle any exceptions during static code analysis
        echo "An error occurred during static code analysis: ${e.message}"
    } finally {
        arch.call()
    }
}  
