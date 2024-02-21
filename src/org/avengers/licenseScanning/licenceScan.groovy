package org.avengers.licenseScanning

def installFossa() {
    stage('Download and Install FOSSA') {
        script {           
            sh 'curl -H \'Cache-Control: no-cache\' https://raw.githubusercontent.com/fossas/fossa-cli/master/install-latest.sh | bash'
        }
    }
}

def scan() {
    stage('FOSSA Analyze & Test') {
        script {
            sh 'fossa analyze'
            // sh 'fossa test'
            sh 'fossa report attribution --format html'
        }
    }
}
