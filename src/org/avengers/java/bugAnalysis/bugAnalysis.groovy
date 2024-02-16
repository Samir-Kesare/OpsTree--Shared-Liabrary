package org.avengers.java.BugAnalysis

def call() {
  stage('Test'){
    script{
      sh 'mvn test'
    }
  }
}
