package org.avengers.java.staticCodeAnalysis

def call(String organization, String projectKey) {
  stage('Static Code Analysis'){
        withSonarQubeEnv(installationName: 'sq1') { 
          sh 'mvn clean verify sonar:sonar -Dsonar.organization=${organization} -Dsonar.projectKey=${projectKey}'
        }    
  }
}
