package org.avengers.python.unitTesting

def call() {           
    stage('Create Virtual ENV') {
        script {
            sh 'python3 -m venv myenv'
            sh '. myenv/bin/activate'
        }
    }
}

