package org.avengers.template.genericCi

import org.avengers.genericCi.packerAmi.AwsCreds 

def call(){
  def awsCred = new AwsCreds() // Use 'def' to declare the variable
  packerInit = new PackerInit()
  packerBuild = new PackerBuild()

  awsCred.call() 
  packerInit.call()
  packerBuild.call()
}
