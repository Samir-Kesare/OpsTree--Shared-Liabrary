package org.avengers.react

def bugAnalysis() {
    stage('Bug Analysis') {
                // steps {
                    script {
                        // sh 'sudo apt-get update && sudo apt-get install -y npm'
                        sh 'npm install'
                        sh 'npm ci'
                        sh 'echo "module.exports = { extends: \'eslint:recommended\' };" > .eslintrc.js'
                        sh 'npx eslint . --ext .js,.jsx --format html --output-file eslint-report.html || true'
                    }
                // }
    }
}

def dpCheck() {
        stage('Dependency Check') {
            // steps {
                sh 'npm install'
                dependencyCheck additionalArguments: '--project dp-check --scan /var/lib/jenkins/workspace/frontendCI/  --format HTML', odcInstallation: 'DP-check'
            // }
        }
}
