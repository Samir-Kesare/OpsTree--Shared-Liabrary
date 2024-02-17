package org.avengers.python.staticCodeAnalysis

def call() {
stage('Create Virtual ENV') {
                    script {
                    sh 'python3 -m venv myenv'
                    sh '. myenv/bin/activate'
                }
            }
          }
        
