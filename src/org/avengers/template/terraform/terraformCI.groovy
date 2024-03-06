package org.avengers.template.terraform

import org.avengers.common.*
import org.avengers.terraform_CICD.*

def call(String url, String creds, String branch, String rootPath, String childPath){

    variablization = new action()
    gitCheckoutPrivate = new GitCheckoutPrivate()
    initialization = new init()
    formating = new fmt()
    validation = new validate()
    linting = new linting()
    securitychecks = new checkov()
    cleanWorkspace = new cleanWorkspace()


    cleanWorkspace.call()
    gitCheckoutPrivate.call(url, creds, branch)
    variablization.call(rootPath, childPath)
    initialization.call(rootPath, childPath)
    formating.call(rootPath, childPath)
    validation.call(rootPath, childPath)
    securitychecks.call(rootPath, childPath)
    linting.call(rootPath, childPath)
    // securitychecks.call(rootPath, childPath)

}
