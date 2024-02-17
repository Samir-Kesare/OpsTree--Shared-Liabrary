package org.avengers.template.genericCi

import org.avengers.genericCi.packerAmi.*

def call(){
  awsCred = new AwsCreds ()
  packerInit = new PackerInit()
  packerBuild = new PackerBuild()

  awsCreds.call()
  packerInit.call()
  packerBuild.call()
}
