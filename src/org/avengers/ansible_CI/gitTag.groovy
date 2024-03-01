package org.avengers.ansible_CI
def call(String tagVersion) {
  stage('Git Tag Stage') {
            script {
                // Tag the version
                sh 'git tag -a v${tagVersion} -m "Version ${tagVersion}"'
            }
        }
}
