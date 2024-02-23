package org.avengers.python.unitTesting

def call() {
    stage('Unit Test') {
        script {
            sh '. myenv/bin/activate'
            sh 'pytest router/tests/test_cache.py'
        }
    }
}
