package org.avengers.template.python

import org.avengers.common.*
import org.avengers.python.staticCodeAnalysis.*

def call(String url, String creds, String branch) {
  
    GitCheckoutPrivate gitCheckoutPrivate = new GitCheckoutPrivate()
    VirtualEnv virtual = new VirtualEnv()
    Dependencies dep = new Dependencies()
    StaticCodeAnalysis code = new StaticCodeAnalysis()
    ArchiveArtifacts arch = new ArchiveArtifacts() 
  
    gitCheckoutPrivate.call(url, creds, branch)
    virtual.call()
    dep.call()
    code.call()
    try {
        arch.call()
    } catch (Exception e) {
        echo 'Report generation failed!'
    }
}
