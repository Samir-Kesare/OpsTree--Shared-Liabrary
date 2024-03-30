package org.avengers.template.terragrunt

import org.avengers.common.*
import org.avengers.terragrunt.TerragruntUtils

def call(String url, String creds, String branch, String rootPath, String childPath, String action) {
    def utils = new TerragruntUtils()
    gitCheckoutPrivate = new GitCheckoutPrivate()

    gitCheckoutPrivate.call(url, creds, branch)
    
    utils.init(rootPath, childPath)
    utils.plan(rootPath, childPath)
    utils.apply(rootPath, childPath)

    if (action == 'Yes') {
        utils.destroy(rootPath, childPath)
    } else (action == 'No') {
        error("Invalid action specified: ${action}")

}
