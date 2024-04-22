package org.avengers.template.deployment

import org.avengers.common.*
import org.avengers.blue_green.terragruntUtils

def call(String url, String creds, String branch, String rootPath, String childPath, String action) {
    def utils = new TerragruntUtils()
    gitCheckoutPrivate = new GitCheckoutPrivate()
    def approval = new approval()
    def applyMsg = 'Do you want to apply the changes ?'
    def destroyMsg = 'Do you want to destroy the changes ?'

    
    gitCheckoutPrivate.call(url, creds, branch)

    // if (action == 'apply') {
    //     utils.init(rootPath, childPath)
    //     utils.plan(rootPath, childPath)
    //     approval.call(applyMsg)
    //     utils.apply(rootPath, childPath)
    // } else if (action == 'destroy') {
    //     approval.call(destroyMsg)
    //     utils.destroy(rootPath, childPath)
    // } else {
    //     error("Invalid action specified: ${action}")
    // }

}
