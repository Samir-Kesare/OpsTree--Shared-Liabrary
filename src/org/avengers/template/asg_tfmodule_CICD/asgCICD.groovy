package org.avengers.template.asg_tfmodule_CICD


import org.avengers.common.*
import org.avengers.asg_tfmodule_CICD.*

def call(String url, String creds, String branch, String rootPath, String childPath, String tagVersion, String gitpath){

    
    gitCheckoutPrivate = new GitCheckoutPrivate()
    asg_tfmodule_CI = new asg_tfmodule_CI()
    asg_tfmodule_CD = new asg_tfmodule_CD()
    
    gitCheckoutPrivate.call(url, creds, branch)
    asg_tfmodule_CI.call(rootPath, childPath, tagVersion)
    asg_tfmodule_CD.call(gitpath, creds, tagVersion)
}
