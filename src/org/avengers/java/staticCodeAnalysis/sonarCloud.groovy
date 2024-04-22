package org.avengers.java.staticCodeAnalysis

def call(String organization, String projectKey) {
  
  stage('Static Code Analysis'){
        withSonarQubeEnv(installationName: 'sq1') { 
          sh './mvnw org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar -Dsonar.organization=${organization} -Dsonar.projectKey=${projectKey}'
        }    
  }
}
