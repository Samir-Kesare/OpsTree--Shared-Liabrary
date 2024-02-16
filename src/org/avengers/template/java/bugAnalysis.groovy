package org.avengers.template.java

import org.avengers.common.gitCheckout
import org.avengers.common.cleanWorkspace
import org.avengers.java.bugAnalysis.*

def call(Map config = [:]){
    def gitCheckout = new gitCheckout()
    def javaBugAnalysis = new bug()
    def javaPublishHtml = new publishHtml()
    def cleanWorkspace = new cleanWorkspace()

    gitCheckout.call(branch: config.branch, url: config.url  )
    javaBugAnalysis.call()
    javaPublishHtml.call()
    cleanWorkspace.call()
  
}
