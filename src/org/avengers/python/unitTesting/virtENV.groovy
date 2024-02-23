package org.avengers.python.unitTesting

def call(){           
        stage('Creat Virtual ENV') 
        {
            steps 
            {
                script 
                {
                  sh 'python3 -m venv myenv'
                  sh '. myenv/bin/activate'
                }
            }
        }
}
