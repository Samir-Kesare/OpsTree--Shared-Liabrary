package org.avengers.template.asg_tfmodule_CICD


import org.avengers.common.*
import org.avengers.asg_tfmodule_CICD.*

def call(String url, String creds, String branch, String rootPath, String childPath, String tagVersion){

    
    gitCheckoutPrivate = new GitCheckoutPrivate()
    asg_tfmodule_CI = new asg_tfmodule_CI()
    
    
    gitCheckoutPrivate.call(url, creds, branch)
    asg_tfmodule_CI.call(rootPath, childPath, tagVersion)
}
