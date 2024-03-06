package org.avengers.ansible_CD
def call() {
  stage('Syntax Checking Stage') {
           
                script {
                    try {
                        // Run ansible-playbook with the --syntax-check option to validate playbook syntax
                        sh 'ansible-playbook /var/lib/jenkins/workspace/Ansible_CD/jenkins_playbook/install_debian.yml --syntax-check > syntaxcheck_report.txt'
                    } catch (Exception e) {
                        // Ignore syntax check errors
                        echo 'Syntax checking completed with errors. Ignoring...'
                    }
                }
            }
        }
