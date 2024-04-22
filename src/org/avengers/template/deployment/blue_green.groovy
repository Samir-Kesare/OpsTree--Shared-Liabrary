package org.avengers.template.deployment

import org.avengers.common.*
import org.avengers.blue_green.*

def call(String url, String creds, String branch, String rootPath, String childPath, String action, String extraVars) {
    def utils = new terragruntUtils()
    gitCheckoutPrivate = new GitCheckoutPrivate()
    def approval = new approval()
    def applyMsg = 'Do you want to apply the changes ?'
    def destroyMsg = 'Do you want to destroy the changes ?'

    
    gitCheckoutPrivate.call(url, creds, branch)

    if (action == 'apply') {
        utils.init(rootPath, childPath)
        utils.plan(rootPath, childPath, extraVars)
        approval.call(applyMsg)
        utils.apply(rootPath, childPath, extraVars)
        utils.healthCheck(rootPath, childPath)
    } else if (action == 'destroy') {
        approval.call(destroyMsg)
        utils.destroy(rootPath, childPath)
    } else {
        error("Invalid action specified: ${action}")
    }

}
