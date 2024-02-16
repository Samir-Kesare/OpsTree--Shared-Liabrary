package org.avengers.template

import org.avengers.common.gitCheckout
import org.avengers.common.cleanWorkspace
import org.avengers.java.compile.*

  def call(String url, String branch){
    gitCheckout = new gitCheckout()
    javaCompile = new compile()
    cleanWorkspace = new cleanWorkspace()
    gitCheckout.call(branch: branch, url: url)
    javaCompile.call()
    cleanWorkspace.call()
  }

  
