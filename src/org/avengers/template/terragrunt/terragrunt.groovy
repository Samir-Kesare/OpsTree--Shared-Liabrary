package org.avengers.template.terragrunt

import org.avengers.common.*
import org.avengers.terragrunt.terragruntUtils

def call(String url, String creds, String branch, String rootPath, String childPath) {
    def utils = new terragruntUtils()
    gitCheckoutPrivate = new GitCheckoutPrivate()

    gitCheckoutPrivate.call(url, creds, branch)
    
    utils.init()
    utils.plan()
    utils.apply()
}
