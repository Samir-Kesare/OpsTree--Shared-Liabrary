package org.avengers.template

import org.avengers.python.BugsAnalysis.*
import org.avengers.python.dependencyScanning.*
import org.avengers.python.staticCodeAnalysis.*
import org.avengers.common.*  

def call(String url, String creds, String branch, String depVersion) {
    //common
    gitCheckoutPrivate = new GitCheckoutPrivate()
    cleanW = new cleanWorkspace()

    // Static code analysis
    VirtualEnv = new virtualEnv()
    Dependencies = new dependencies()
    StaticCodeAnalysis = new staticCodeAnalysis()
    archive = new ArchiveArtifacts() 

    // bugs analysis
    bugsAnalysisBandit = new BugsAnalysisBandit()
    installDependencies = new InstallDependencies()

    // dependency scanning
    downloadDependencyCheck = new DownloadDependencyCheck()
    dependencyCheck = new DependencyCheck()


    downloadDependencyCheck.call(depVersion) 
    gitCheckoutPrivate.call(url, creds, branch)
    dependencyCheck.call()
    clean.call()
    cleanWorkspace.call()
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
