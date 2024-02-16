package org.avengers.template

import org.avengers.common.gitCheckout
import org.avengers.common.cleanWorkspace
import org.avengers.java.compile.*
import org.avengers.java.staticCodeAnalysis.*

def call(Map config = [:]){
    def gitCheckout = new gitCheckout()
    def javaCompile = new compile()
    def staticCodeAnalysis = new staticCodeAnalysis()
    def cleanWorkspace = new cleanWorkspace()

    gitCheckout.call(branch: config.branch, url: config.url  )
    javaCompile.call()
    staticCodeAnalysis.call()
    cleanWorkspace.call()
  }
}
