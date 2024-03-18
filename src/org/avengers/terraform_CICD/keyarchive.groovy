
package org.avengers.terraform_CICD

def call() {
    stage("Pem Key Archive") {
        script {
            archiveArtifacts artifacts: '*.pem', allowEmptyArchive: true
        }
    }
}
