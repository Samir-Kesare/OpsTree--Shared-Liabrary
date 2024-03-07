package org.avengers.ansibleRole_CD
def call(String path) {
  stage('Git Push Version Stage') {
            script {
                // Push the tagged version to the remote repository
                withCredentials([usernamePassword(credentialsId: '${creds}', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh 'git push ${path}'
                }
            }
        }
