package org.avengers.golang.dast

def call() {
    stage('Linting Stage') {
       
            script {
                try {
                    // Use Ansible Lint to perform linting on your Ansible playbook
                    sh 'ansible-lint /var/lib/jenkins/workspace/Ansible_CI/jenkins_playbook/install_debian.yml -q > lint_report.txt'
                } catch (Exception e) {
                    // Ignore linting errors
                    echo 'Linting completed with errors. Ignoring...'
                }
            }
        }
    }


            
                
