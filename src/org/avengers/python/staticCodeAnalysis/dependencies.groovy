package org.avengers.python.staticCodeAnalysis

def call() {
stage('Install dependencies') {
            steps {
                script {
                    sh 'python3 -m pip install -r requirements.txt'
                }
            }
        } 
}
