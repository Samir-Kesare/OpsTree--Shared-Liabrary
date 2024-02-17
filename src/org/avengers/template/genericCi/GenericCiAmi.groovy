package org.avengers.template.genericCi

import org.avengers.genericCi.packerAmi.AwsCreds // Import the AwsCreds class

def call(){
  def awsCred = new AwsCreds() // Use 'def' to declare the variable
  def packerInit = new PackerInit()
  def packerBuild = new PackerBuild()

  awsCred.call() 
  packerInit.call()
  packerBuild.call()
}
