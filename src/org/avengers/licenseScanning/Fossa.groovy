package org.avengers.licenseScanning

def call() {
    stage('Download and Install FOSSA') {
        script {           
            sh 'curl -H \'Cache-Control: no-cache\' https://raw.githubusercontent.com/fossas/fossa-cli/master/install-latest.sh | bash'
        }
    }
}
