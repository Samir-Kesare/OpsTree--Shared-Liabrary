package org.avengers.java.bugAnalysis

def call(){           
        stage("Bug Analysis ") {
            steps {
                script {
                    sh 'mvn compile'
                    sh 'mvn spotbugs:spotbugs'
                    sh 'mvn site'
                }
            }
        }
        
