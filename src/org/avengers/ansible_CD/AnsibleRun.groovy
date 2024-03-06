package org.avengers.ansible_CD
def call() {
  stage('Ansible Run Stage') {
            script {
                // Run the ansible playbook
                sh 'ansible-playbook /var/lib/jenkins/workspace/Ansible_CD/jenkins_playbook/install_debian.yml'
            }
        }
    }
