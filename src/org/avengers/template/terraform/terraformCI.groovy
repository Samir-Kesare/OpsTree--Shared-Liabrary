package org.avengers.template.terraform

import org.avengers.common.*



def call(String url, String cred, String branch, String rootPath, String childPath, String version) {

    gitCheckoutPrivate = new GitCheckoutPrivate()
    tf = new org.mygurukulam.terraform.Action()
    lint = new org.avengers.terraform_CICD.linting()
    cleanup = new org.mygurukulam.common.Cleanup()

    cleanup.call()
    git.call(url, cred, branch)
    tf.call(rootPath, childPath, "init")
    tf.call(rootPath, childPath, "validate")
    tf.call(rootPath, childPath, "plan")
    lint.call(rootPath, childPath)
}
