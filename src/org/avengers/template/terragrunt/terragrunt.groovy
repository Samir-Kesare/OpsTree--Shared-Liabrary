package org.avengers.template.terragrunt

import org.avengers.terragrunt.terragruntUtils

def call() {
    def utils = new terragruntUtils()

    utils.init()
    utils.plan()
    utils.apply()
}
