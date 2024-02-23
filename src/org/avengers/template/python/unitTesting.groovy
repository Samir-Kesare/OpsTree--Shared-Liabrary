package org.avengers.template.java

import org.avengers.common.gitCheckout
import org.avengers.common.cleanWorkspace
import org.avengers.python.unitTesting.*

def call(Map config = [:]){
    def gitCheckout = new gitCheckout()
    def Installdependency = new installDependency()
    def unitTest = new testing()
    def virtenv = new virtENV()
    def cleanWorkspace = new cleanWorkspace()

    gitCheckout.call(branch: config.branch, url: config.url  )
    virtenv.call()
    Installdependency.call()
    unitTest.call()
    cleanWorkspace.call()
  
}
