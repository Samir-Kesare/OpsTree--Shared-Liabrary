// installDependency.groovy
package org.avengers.python.unitTesting

def call() {
    stage('Install Dependencies') {
        steps {
            script {
                sh 'pip install -r requirements.txt'
                sh 'pip install pytest pytest-html'
            }
        }
    }
}

