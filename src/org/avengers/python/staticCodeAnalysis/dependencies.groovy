package org.avengers.java.staticCodeAnalysis

def call() {
stage('Install dependencies') {
            steps {
                script {
                    sh 'python3 -m pip install -r requirements.txt'
                }
            }
        } 
}
