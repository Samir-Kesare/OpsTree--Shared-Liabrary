package org.avengers.ansible_CD
def call(String path) {
  stage('Ansible Run Stage') {
            script {
                // Run the ansible playbook
                sh 'ansible-playbook ${path}'
            }
        }
    }
