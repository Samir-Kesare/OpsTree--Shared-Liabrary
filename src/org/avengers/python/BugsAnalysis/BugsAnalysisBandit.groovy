package  org.avengers.python.BugsAnalysis
def call() {
  stage('Bugs Analysis - Bandit') {
                script {
              
                        // Ensure Bandit is installed and run the analysis
                        sh 'bandit --version' 
                        sh 'bandit -r . -f json -o bandit_report.json'
                    
                    }
                }
            }
        
    

