package org.avengers.template.java

import org.avengers.common.gitCheckout
import org.avengers.common.cleanWorkspace
import org.avengers.java.unitTesting.*

def call(Map config = [:]){
    def gitCheckout = new gitCheckout()
    def javaUnitTesting = new test()
    def cleanWorkspace = new cleanWorkspace()

    gitCheckout.call(branch: config.branch, url: config.url  )
    javaUnitTesting.call()
    cleanWorkspace.call()
  
}
