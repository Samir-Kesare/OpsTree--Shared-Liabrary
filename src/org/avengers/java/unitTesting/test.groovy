package org.avengers.java.unitTesting

def call(){           
        stage("Unit Testing ") {
                script {
                   
                    sh 'mvn test'
                }
            }
}
      
