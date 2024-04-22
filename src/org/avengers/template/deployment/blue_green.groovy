package org.avengers.template.deployment

import org.avengers.common.*
import org.avengers.blue_green.*

def call(String url, String creds, String branch, String rootPath, String childPath, String action) {
    def utils = new terragruntUtils()
    gitCheckoutPrivate = new GitCheckoutPrivate()
    def approval = new approval()
    def createGreenTGApproval = 'Do you want to create Green TG ?'
    def deployGreenApproval = 'Do you want to deploy Green TG ?'
    def destroyMsg = 'Do you want to destroy the changes ?'

    
    gitCheckoutPrivate.call(url, creds, branch)

    if (action == 'apply') {
        utils.init(rootPath, childPath)
        utils.plan(rootPath, childPath, extraVars)
        approval.call(createGreenTGApproval)
        utils.createGreenTG(rootPath, childPath)
        utils.healthCheck(rootPath, childPath)
        approval.call(deployGreenApproval)
        utils.deployGreen(rootPath, childPath)
    } else if (action == 'destroy') {
        approval.call(destroyMsg)
        utils.destroy(rootPath, childPath)
    } else {
        error("Invalid action specified: ${action}")
    }

}
