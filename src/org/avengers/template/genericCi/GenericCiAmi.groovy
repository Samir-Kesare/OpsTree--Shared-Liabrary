package org.avengers.template.genericCi

import org.avengers.genericCi.packerAmi.AwsCreds 
import org.avengers.genericCi.packerAmi.PackerInit
import org.avengers.genericCi.packerAmi.PackerBuild

def call(){
  def awsCred = new AwsCreds() // Use 'def' to declare the variable
  def packerInit = new PackerInit()
  def packerBuild = new PackerBuild()

  awsCred.call() 
  packerInit.call()
  packerBuild.call()
}
