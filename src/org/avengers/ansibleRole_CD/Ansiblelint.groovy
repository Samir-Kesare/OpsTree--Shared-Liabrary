package org.avengers.ansibleRole_CD
def call(String path) {
    stage('Linting Stage') {
       
            script {
                try {
                    // Use Ansible Lint to perform linting on your Ansible playbook
                    sh "ansible-lint ${path} -q > lint_report.txt"
                } catch (Exception e) {
                    // Ignore linting errors
                    echo 'Linting completed with errors. Ignoring...'
                }
            }
        }
    }
