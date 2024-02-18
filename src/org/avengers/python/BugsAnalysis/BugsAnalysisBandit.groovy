package  org.avengers.python.BugsAnalysis
def call() {
  stage('Bugs Analysis - Bandit') {
                script {
                    try {
                        // Ensure Bandit is installed and run the analysis
                        sh 'bandit --version' // Check Bandit version to ensure it's installed
                        sh 'bandit -r . -f json -o bandit_report.json'
                    } catch (Exception e) {
                        echo "Bugs analysis failed: ${e.message}"
                    }
                }
            }
        }
    

