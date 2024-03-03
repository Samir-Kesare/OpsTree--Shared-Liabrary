package org.avengers.template.terraform

import org.avengers.common.*



def call(String url, String cred, String branch, String rootPath, String childPath, String version) {

    def git = new org.mygurukulam.common.Checkout()
    def credScan = new org.mygurukulam.common.CredentialScanning()
    def tf = new org.mygurukulam.terraform.Action()
    def staticCode = new org.mygurukulam.terraform.Security()
    def lint = new org.mygurukulam.terraform.Linting()
    def cleanup = new org.mygurukulam.common.Cleanup()

    cleanup.call()
    git.call(url, cred, branch)
    credScan.call(rootPath)
    tf.call(rootPath, childPath, "init")
    tf.call(rootPath, childPath, "validate")
    tf.call(rootPath, childPath, "plan")
    staticCode.call(rootPath, childPath)
    lint.call(rootPath, childPath)
}
