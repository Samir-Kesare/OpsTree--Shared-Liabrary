package org.avengers.template.terraform

import org.avengers.common.*
import org.avengers.terraform_CICD.*

def call(String url, String creds, String branch, String rootPath, String childPath, String reportName1, String reportName2){

    variablization = new action()
    gitCheckoutPrivate = new GitCheckoutPrivate()
    initialization = new init()
    formating = new fmt()
    validation = new validate()
    linting = new linting()
    securitychecks = new checkov()
    cleanWorkspace = new cleanWorkspace()
    archiving = new ArchivewithoutClean()

    cleanWorkspace.call()
    gitCheckoutPrivate.call(url, creds, branch)
    variablization.call(rootPath, childPath)
    initialization.call(rootPath, childPath)
    formating.call(rootPath, childPath)
    validation.call(rootPath, childPath)
    securitychecks.call(rootPath, childPath)
    linting.call(rootPath, childPath)
    archiving.call(reportName1)
    archiving.call(reportName2)
    // securitychecks.call(rootPath, childPath)

}
