package org.avengers.ansibleRole_CD
def call(String path) {
  stage('Syntax Checking Stage') {
           
                script {
                    try {
                        // Run ansible-playbook with the --syntax-check option to validate playbook syntax
                        sh "ansible-playbook ${path} --syntax-check > syntaxcheck_report.txt"
                    } catch (Exception e) {
                        // Ignore syntax check errors
                        echo 'Syntax checking completed with errors. Ignoring...'
                    }
                }
            }
        }
