package org.avengers.react

def bugAnalysis() {
    stage('Bug Analysis') {
                steps {
                    script {
                        sh 'npm install'
                        sh 'npm ci'
                        sh 'echo "module.exports = { extends: \'eslint:recommended\' };" > .eslintrc.js'
                        sh 'npx eslint . --ext .js,.jsx --format html --output-file eslint-report.html || true'
                    }
                }
    }
}

