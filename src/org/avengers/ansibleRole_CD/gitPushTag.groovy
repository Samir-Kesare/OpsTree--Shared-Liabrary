package org.avengers.ansibleRole_CD
def call(String gitpath, String creds) {
  stage('Git Push Version Stage') {
            script {
                // Push the tagged version to the remote repository
                withCredentials([usernamePassword(credentialsId: "${creds}", usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh "git push https://username:${PASSWORD}@github.com/${gitpath} v1.0"
                }
            }
        }
}
