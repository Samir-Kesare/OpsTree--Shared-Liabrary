package org.avengers.template.Attandance_CI

import org.avengers.python.BugsAnalysis.*
import org.avengers.python.dependencyScanning.*
import org.avengers.python.staticCodeAnalysis.*
import org.avengers.common.*  

def call(String url, String creds, String branch) {
    //common definition
    def gitCheckoutPrivate = new GitCheckoutPrivate()
    // def cleanW = new cleanWorkspace()

    // Static code analysis definition
    def VirtualEnv = new virtualEnv()
    def Dependencies = new dependencies()
    def StaticCodeAnalysis = new staticCodeAnalysis()
    def archive = new ArchiveArtifacts() 

    // bugs analysis definition
    // def bugsAnalysisBandit = new BugsAnalysisBandit()
    // def installDependencies = new InstallDependencies()

    // // dependency scanning definition
    // def downloadDependencyCheck = new DownloadDependencyCheck()
    // def dependencyCheck = new DependencyCheck()
    // def cleandp = new Clean()

    // static code analysis 
      try {
        gitCheckoutPrivate.call(url, creds, branch)
        VirtualEnv.call()
        Dependencies.call()
        StaticCodeAnalysis.call()
    } catch (Exception e) {
        // Handle any exceptions during static code analysis
        echo "An error occurred during static code analysis: ${e.message}"
    } finally {
        archive.call()
    }

    
    // downloadDependencyCheck.call(depVersion) 
    // gitCheckoutPrivate.call(url, creds, branch)
    // dependencyCheck.call()
    // cleandp.call()
    // cleanW.call()
    // bugsAnalysisBandit.call()
    // installDependencies.call()
    
    // try {
    //     virtual.call()
    //     dep.call()
    //     code.call()
    // } catch (Exception e) {
    //     // Handle any exceptions during static code analysis
    //     echo "An error occurred during static code analysis: ${e.message}"
    // } finally {
    //     arch.call()
    // }
}  
