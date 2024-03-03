package org.avengers.template.terraform

import org.avengers.common.*
import org.avengers.terraform_CICD.*

def call(String url, String cred, String branch, String rootPath, String childPath) {

    gitCheckoutPrivate = new GitCheckoutPrivate()
    initialization = new init()
    formating = new fmt()
    validation = new validate()
    linting = new linting()
    securitychecks = new checkov()
    cleanWorkspace = new cleanWorkspace()

    
    cleanWorkspace.call()
    gitCheckoutPrivate.call()
    initialization.call()
    formating.call()
    validation.call()
    linting.call()
    securitychecks.call()

}
