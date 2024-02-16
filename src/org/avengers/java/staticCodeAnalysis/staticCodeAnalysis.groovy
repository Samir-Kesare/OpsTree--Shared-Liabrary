package org.avengers.java.staticCodeAnalysis

def call() {
  stage('Static Code Analysis'){
        withSonarQubeEnv(installationName: 'sq1') { 
          sh './mvnw org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar'
        }    
  }
}
