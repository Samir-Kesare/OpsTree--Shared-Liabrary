package org.avengers.template

import org.avengers.common.gitCheckout
// import org.avengers.common.cleanWorkspace
import org.avengers.java.compile.*

def call(String url, String branch){
    def gitCheckout = new gitCheckout()
    def javaCompile = new compile()
    // def cleanWorkspace = new cleanWorkspace()
    gitCheckout.call(branch: branch, url: url)
    javaCompile.call()
    // cleanWorkspace.call()
  }

  
