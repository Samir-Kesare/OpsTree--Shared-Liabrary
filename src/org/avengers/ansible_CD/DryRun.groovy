package org.avengers.ansible_CD
def call(String path) {
  stage('Dry Run Stage') {
            script {
                // Perform a dry run 
                sh 'ansible-playbook ${path} --check'
            }
        }
}
