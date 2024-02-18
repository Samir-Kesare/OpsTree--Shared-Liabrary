package org.avengers.template.python

import org.avengers.common.*
import org.avengers.python.staticCodeAnalysis.*

def call(String url, String creds, String branch) {
  
     gitCheckoutPrivate = new GitCheckoutPrivate()
     virtual = new VirtualEnv()
     dep = new Dependencies()
     code = new StaticCodeAnalysis()
     arch = new ArchiveArtifacts() 
  
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
