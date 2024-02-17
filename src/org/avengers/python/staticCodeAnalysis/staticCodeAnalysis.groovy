package org.avengers.python.staticCodeAnalysis

def call() {
stage('Static Code Analysis') {
            steps {
                script {
                    sh 'pylint router/ client/ models/ utils/ app.py | tee pylint.log'
                }
            }
        }
    }
