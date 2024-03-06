package org.avengers.ansible_CD
def call() {
    stage('Linting Stage') {
       
            script {
                try {
                    // Use Ansible Lint to perform linting on your Ansible playbook
                    sh 'ansible-lint /var/lib/jenkins/workspace/Ansible_CD/jenkins_playbook/install_debian.yml -q > lint_report.txt'
                } catch (Exception e) {
                    // Ignore linting errors
                    echo 'Linting completed with errors. Ignoring...'
                }
            }
        }
    }

