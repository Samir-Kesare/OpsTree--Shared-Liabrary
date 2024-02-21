package org.avengers.template

import org.avengers.python.BugsAnalysis.*
import org.avengers.python.dependencyScanning.*
import org.avengers.python.staticCodeAnalysis.*
import org.avengers.common.*  

def call(String url, String creds, String branch, String depVersion,) {
    GitCheckoutPrivate gitCheckoutPrivate = new GitCheckoutPrivate()
    VirtualEnv virtual = new VirtualEnv()
    Dependencies dep = new Dependencies()
    StaticCodeAnalysis code = new StaticCodeAnalysis()
    ArchiveArtifacts arch = new ArchiveArtifacts() 
    CleanWorkspace cleanWorkspace = new CleanWorkspace()
    BugsAnalysisBandit bugsAnalysisBandit = new BugsAnalysisBandit()
    InstallDependencies installDependencies = new InstallDependencies()
    DownloadDependencyCheck downloadDependencyCheck = new DownloadDependencyCheck()
    DependencyCheck dependencyCheck = new DependencyCheck()
    Clean = new Clean()

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
