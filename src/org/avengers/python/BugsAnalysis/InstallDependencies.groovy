package  org.avengers.python.BugsAnalysis
def calll() {
  stage('Install Dependencies') {
    // Install necessary dependencies
    script {
      sh 'python3 -m venv myenv'
      sh '. myenv/bin/activate'
                }
            }
        }




