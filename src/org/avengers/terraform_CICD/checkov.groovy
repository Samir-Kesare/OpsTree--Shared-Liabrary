package org.avengers.terraform_CICD

def call(String rootPath, String childPath) {
    stage('checkov') {
        script {
            //sh "pip install checkov"
        //    sh "python3 -m pip install checkov"
          //  sh 'echo "export PATH=\"`python3 -m site --user-base`/bin:\$PATH\"" >> ~/.bashrc'
           // sh "source ~/.bashrc"
          //  sh 'export PATH="$HOME/.local/bin:$PATH"'
           // sh "sudo apt install pipenv -y"
           // sh "pip install checkov"
        //    sh "/var/lib/jenkins/.local/bin/checkov -d . -s"
            sh "cd ${rootPath}/${childPath} && /var/lib/jenkins/.local/bin/checkov -d . -s --output-file-path . --skip-path ./tflint_report.jsonֿ"
        }
    }
}
