
package org.avengers.terraform_CICD

def call(String rootPath, String childPath) {
    stage("Pem Key Archive") {
        script {
            archiveArtifacts artifacts: "${rootPath}/${childPath}/*.pem", allowEmptyArchive: true
        }
    }
}
