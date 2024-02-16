package org.avengers.java.compile

def call() {
  stage('Compile'){
    script{
      sh 'mvn clean compile'
    }
  }
}
