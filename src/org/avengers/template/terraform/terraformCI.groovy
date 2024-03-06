package org.avengers.template

import org.avengers.common.*
import org.avengers.terraform_CICD.*

def call(String url, String cred, String branch, String rootPath, String childPath){

    variablization = new action()
    gitCheckoutPrivate = new GitCheckoutPrivate()
    initialization = new init()
    formating = new fmt()
    validation = new validate()
    linting = new linting()
    securitychecks = new checkov()
    cleanWorkspace = new cleanWorkspace()


    variablization.call(rootPath, childPath)
    cleanWorkspace.call()
    gitCheckoutPrivate.call(url, creds, branch)
    initialization.call(rootPath, childPath)
    formating.call(rootPath, childPath)
    validation.call(rootPath, childPath)
    linting.call(rootPath, childPath)
    securitychecks.call(rootPath, childPath)

}
