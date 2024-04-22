package org.avengers.template.deployment

import org.avengers.common.*
import org.avengers.blue_green.*

def call(String url, String creds, String branch, String rootPath, String greenPath, String action, String bluePath) {
    def utils = new terragruntUtils()
    gitCheckoutPrivate = new GitCheckoutPrivate()
    def approval = new approval()
    def createGreenTGApproval = 'Do you want to create Green TG ?'
    def deployGreenApproval = 'Do you want to deploy Green TG ?'
    def destroyMsg = 'Do you want to destroy the changes ?'

    
    gitCheckoutPrivate.call(url, creds, branch)

    if (action == 'apply') {
        utils.init(rootPath, greenPath)
        utils.plan(rootPath, greenPath)
        approval.call(createGreenTGApproval)
        utils.createGreenTG(rootPath, greenPath)
        utils.healthCheck(rootPath, greenPath)
        approval.call(deployGreenApproval)
        utils.deployGreen(rootPath, greenPath)
    } else if (action == 'destroy') {
        approval.call(destroyMsg)
        utils.destroy(rootPath, greenPath)
    }

}
