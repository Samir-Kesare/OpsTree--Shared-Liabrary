package org.avengers.ansibleRole_CD
def call() {
  stage('Git Push Version Stage') {
            script {
                // Push the tagged version to the remote repository
                withCredentials([usernamePassword(credentialsId: 'f941d7e1-ff1a-4bca-835c-a458a1b3d96a', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh 'git push https://username:${PASSWORD}@github.com/CodeOps-Hub/Jenkins-Playbook.git v1.1'
                }
            }
        }
