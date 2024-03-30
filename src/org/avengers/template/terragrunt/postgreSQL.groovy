package org.avengers.template.terragrunt

import org.avengers.common.*
import org.avengers.terragrunt.TerragruntUtils

def call(String url, String creds, String branch, String rootPath, String childPath, String action) {
    def utils = new TerragruntUtils()
    def gitCheckoutPrivate = new GitCheckoutPrivate()
    def approval = new approval()
    
    gitCheckoutPrivate.call(url, creds, branch)
    


    if (action == 'Apply') {
        utils.init(rootPath, childPath)
        utils.plan(rootPath, childPath)
        approval.call()        
        utils.apply(rootPath, childPath)
    } else if (action == 'Destroy') {
        utils.destroy(rootPath, childPath)
    } else {
        error("Invalid action specified: ${action}")
    }

}
