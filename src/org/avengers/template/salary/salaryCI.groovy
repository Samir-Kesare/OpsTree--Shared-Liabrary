package org.avengers.template

import org.avengers.common.gitCheckout
import org.avengers.common.cleanWorkspace
import org.avengers.java.compile.*
import org.avengers.java.staticCodeAnalysis.*
import org.avengers.java.dependencyCheck.*
import org.avengers.java.unitTesting.*
import org.avengers.java.bugAnalysis.*


def call(Map config = [:]){
    def gitCheckout = new gitCheckout()
    def javaCompile = new compile()
    def staticCodeAnalysis = new staticCodeAnalysis()
    def cleanWorkspace = new cleanWorkspace()
    def dpCheck = new dpCheck()
    def javaUnitTesting = new test()
    def javaBugAnalysis = new bug()
    def javaPublishHtml = new publishHtml()

    try{
    gitCheckout.call(branch: config.branch, url: config.url  )
    javaCompile.call()
    dpCheck.call()
    staticCodeAnalysis.call()
    javaBugAnalysis.call()
    javaPublishHtml.call()
    javaUnitTesting.call()
    }
    catch (e){
        echo 'Analysis Failed'
        cleanWorkspace.call()
        throw e
    }
    finally {
         def currentResult = currentBuild.result ?: 'SUCCESS'
        if ((currentResult == 'UNSTABLE')||(currentResult == 'ABORTED')) {
        cleanWorkspace.call()
            // echo 'This will run only if the run was marked as unstable'
        }
    }
}
