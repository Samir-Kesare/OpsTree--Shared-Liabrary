package org.avengers.common

def call(String msg) {
    stage('Approval') {
        input message: "${msg}", ok: 'Yes'
    }
}
