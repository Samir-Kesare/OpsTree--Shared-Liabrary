package  org.avengers.python.BugsAnalysis
def call() {
  stage('Install Dependencies') {
    // Install necessary dependencies
    script {
      sh 'python3 -m venv myenv'
      sh '. myenv/bin/activate'
                }
            }
        }




