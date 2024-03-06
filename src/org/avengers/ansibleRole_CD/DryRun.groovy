package org.avengers.ansibleRole_CD
def call() {
  stage('Dry Run Stage') {
            script {
                // Perform a dry run 
                sh 'ansible-playbook /var/lib/jenkins/workspace/Ansible_CD/jenkins_playbook/install_debian.yml --check'
            }
        }
}
