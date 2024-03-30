package org.avengers.template.terragrunt

import org.avengers.common.*
import org.avengers.terragrunt.TerragruntUtils

def call(String url, String creds, String branch, String rootPath, String childPath) {
    def utils = new TerragruntUtils()
    gitCheckoutPrivate = new GitCheckoutPrivate()

    gitCheckoutPrivate.call(url, creds, branch)
    
    utils.init(rootPath, childPath)
    utils.plan(rootPath, childPath)


    // Pipeline approval
    input(message: 'Proceed with applying or destroying infrastructure?', parameters: [choice(name: 'action', choices: ['Apply', 'Destroy'], description: 'Select action')])

    // Conditional block based on user's choice
    if (params.action == 'Apply') {
        utils.apply(rootPath, childPath)
    } else if (params.action == 'Destroy') {
        utils.destroy(rootPath, childPath)
    } else {
        error('Invalid action selected.')
    }

}
