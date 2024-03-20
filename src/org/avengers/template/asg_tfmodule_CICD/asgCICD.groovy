package org.avengers.template.asg_tfmodule_CICD


import org.avengers.common.*
import org.avengers.asg_tfmodule_CICD.*

def call(String url, String creds, String branch, String rootPath, String childPath, String reportName1, String reportName2, String tagVersion){

    
    gitCheckoutPrivate = new GitCheckoutPrivate()
    archiving = new ArchivewithoutClean()
    asg_tfmodule_CI = new asg_tfmodule_CI()

    gitCheckoutPrivate.call(url, creds, branch)
    asg_tfmodule_CI.call(rootPath, childPath, tagVersion)
    archiving.call(reportName1)
    archiving.call(reportName2)
    // securitychecks.call(rootPath, childPath)

}
