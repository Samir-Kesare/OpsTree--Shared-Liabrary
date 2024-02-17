package org.avengers.template.genericCi

import org.avengers.genericCi.packerAmi.*

def call(){
  packerInit = new PackerInit()
  packerBuild = new PackerBuild()

  packerInit .call()
  packerBuild.call()
}
