
package org.avengers.terraform_CICD

def call() {
    stage("Pem Key Archive") {
        script {
            sh "cd ${rootPath}/${childPath}"
            archiveArtifacts artifacts: '*.pem', allowEmptyArchive: true
        }
    }
}
