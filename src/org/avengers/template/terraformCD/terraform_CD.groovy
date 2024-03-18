package org.avengers.template.terraformCD

import org.avengers.common.*
import org.avengers.terraform_CICD.*

def call(String url, String creds, String branch, String rootPath, String childPath, String ACTION){

    variablization = new action()
    gitCheckoutPrivate = new GitCheckoutPrivate()
    initialization = new init()
    deploying = new deploy()
    keyarchive = new keyarchive()
    
  

    gitCheckoutPrivate.call(url, creds, branch)
    variablization.call(rootPath, childPath)
    initialization.call(rootPath, childPath)
    deploying.call(rootPath, childPath, ACTION)
    keyarchive.call(rootPath, childPath)

}
