package org.avengers.template.python

import org.avengers.common.*
import org.avengers.python.staticCodeAnalysis.*

def call(String url, String creds, String branch) {
  
    gitCheckoutPrivate = new GitCheckoutPrivate()
    virtual = new virtualEnv()
    dep = new dependencies()
    code = new staticCodeAnalysis()
    arch = new ArchiveArtifacts() 
  
    
  
  try {
    gitCheckoutPrivate.call(url, creds, branch)
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

