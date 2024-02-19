package org.avengers.licenseScanning

def call() {
    stage('Download and Install FOSSA') {
        script {
             withCredentials([string(credentialsId: 'fossaToken', variable: 'FOSSA_API_KEY')]){
            sh 'curl -H \'Cache-Control: no-cache\' https://raw.githubusercontent.com/fossas/fossa-cli/master/install-latest.sh | bash'
             }
        }
    }
}
