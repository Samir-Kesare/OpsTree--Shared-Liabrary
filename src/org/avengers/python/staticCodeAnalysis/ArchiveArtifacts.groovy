package org.avengers.python.staticCodeAnalysis

def call() {
stage('Install dependencies') {
            
                script {
                    archiveArtifacts artifacts: '**/pylint.log', allowEmptyArchive: true       
                          
                   
                }
            }
        } 
