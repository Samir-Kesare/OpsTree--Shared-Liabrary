package org.avengers.python.unitTesting

def call(){   
        stage('Unit Test') 
        {
            steps 
            {
                script 
                {
                    sh '. myenv/bin/activate'
                    //sh 'pytest router/tests/test_c
                    sh 'pytest router/tests/test_cache.py'
                    //sh 'pytest /var/lib/jenkins/workspace/unit_test '
                    
                    
                }
            }
        }
}
