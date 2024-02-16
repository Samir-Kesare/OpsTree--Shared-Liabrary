package org.avengers.java.bugAnalysis

def call(){           
        stage("Bug Analysis ") {
                script {
                    sh 'mvn compile'
                    sh 'mvn spotbugs:spotbugs'
                    sh 'mvn site'
                }
        }
}
