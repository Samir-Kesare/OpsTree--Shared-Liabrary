package org.avengers.template.genericCi

import org.avengers.genericCi.packerAmi.*

def call() {
    def awsCred = new AwsCreds()
    def packerInit = new PackerInit()
    def packerBuild = new PackerBuild()

    awsCred.awsCredentials()  // Call the correct method
    packerInit.call()
    packerBuild.call()
}
