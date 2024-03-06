package org.avengers.terraform_CICD

def call(String rootPath, String childPath) {
    stage('checkov') {
        script {
            //sh "pip install checkov"
            sh "python3 -m pip install checkov"
            sh "echo "export PATH=\"`python3 -m site --user-base`/bin:\$PATH\"" >> ~/.bashrc"
            sh "source ~/.bashrc"
            sh "cd ${rootPath}/${childPath} && checkov --directory . || true"
        }
    }
}
