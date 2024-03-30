package org.avengers.template.terragrunt

import org.avengers.common.*
import org.avengers.terragrunt.TerragruntUtils

def call(String url, String creds, String branch, String rootPath, String childPath) {
    def utils = new TerragruntUtils()
    gitCheckoutPrivate = new GitCheckoutPrivate()

    gitCheckoutPrivate.call(url, creds, branch)
    
    utils.init(rootPath, childPath)
    utils.plan(rootPath, childPath)
    utils.apply(rootPath, childPath)
    utils.destroy(rootPath, childPath)

}
