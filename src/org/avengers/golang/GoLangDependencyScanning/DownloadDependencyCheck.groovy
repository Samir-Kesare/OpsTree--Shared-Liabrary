package org.avengers.golang.DownloadDependencyCheck
def call(String depVersion) {
    stage('Download Dependency Check') {
            script {
                sh "wget -q https://github.com/jeremylong/DependencyCheck/releases/download/v${depVersion}/dependency-check-${depVersion}-release.zip"
                sh "sudo apt install unzip -y"
                sh "unzip -q dependency-check-${depVersion}-release.zip"
            }
    }
}
