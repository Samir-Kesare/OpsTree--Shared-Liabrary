package org.avengers.template.CommitSignOff

import org.avengers.CommitSignOff.*
import org.avengers.common.*

def call(){
    gitCommit = new GitCommit()
   

    gitCommit.call()
   
}
