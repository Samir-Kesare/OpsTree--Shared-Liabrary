package org.avengers.template.Module_CI_CD


import org.avengers.common.*
import org.avengers.Module_CI_CD.*

def call(String url, String creds, String branch, String rootPath, String childPath, String tagVersion, String gitpath){

    
    gitCheckoutPrivate = new GitCheckoutPrivate()
    ci = new ci()
    cd = new cd()
    
    gitCheckoutPrivate.call(url, creds, branch)
    ci.call(rootPath, childPath, tagVersion)
    cd.call(gitpath, creds, tagVersion)
}
