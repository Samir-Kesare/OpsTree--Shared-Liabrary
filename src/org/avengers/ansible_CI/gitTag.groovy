package org.avengers.golang.dast
def call(String tagVersion) {
  stage('Git Tag Stage') {
            script {
                // Tag the version
                sh 'git tag -a v${tagVersion} -m "Version ${tagVersion}"'
            }
        }
}
