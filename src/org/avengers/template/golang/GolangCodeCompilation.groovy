//package org.avengers.template.golang


//import org.avengers.common.*
//import org.avengers.golang.CodeCompilation.*

//def call(String url, String creds, String branch){
  //gitCheckoutPrivate = new GitCheckoutPrivate()
  //installationgo = new installationgo()
  //codecompilation = new codecompilation()

  
  //gitCheckoutPrivate.call(url, creds, branch)
  //installationgo.call()
  //codecompilation.call()
//}
  
package org.avengers.template.golang

import org.avengers.common.*
import org.avengers.golang.CodeCompilation.*

def call(String url, String creds, String branch) {
    def gitCheckoutPrivate = new GitCheckoutPrivate()
    def installationgo = new InstallationGo()
    def codeCompilation = new CodeCompilation()

    try {
        gitCheckoutPrivate.call(url, creds, branch)
        installationgo.call()
        codeCompilation.call()
    } catch (Exception e) {
        // Handle exceptions gracefully, e.g., by failing the pipeline with an error message
        echo "Error occurred: ${e.message}"
        currentBuild.result = 'FAILURE'
        throw e
    }
}
