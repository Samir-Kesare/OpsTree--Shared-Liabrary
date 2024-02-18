package org.avengers.python.staticCodeAnalysis

def call() {
stage('Install dependencies') {
            
                script {
                    sh "echo 'pylint==3.0.3' >  requirements.txt"      
                          
                    sh 'python3 -m pip install -r requirements.txt'
                }
            }
        } 

