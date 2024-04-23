package org.avengers.credScanning

def call(String reportName) {
  stage('Gitleaks Scan') {
        // script {
        //    sh "./gitleaks detect -r ${reportName}"
        // }
        sh'''
          ./gitleaks detect --exit-code 1 --report-format json --report-path gitleaks.json -v
        '''
        sh'''
          jq -r 'group_by(.RuleID) | map({RuleID: .[0].RuleID, Count: length}) | (map(.RuleID) | @csv), (map(.Count) | @csv)' gitleaks.json | sed 's/"//g' > cred_scanner.csv
        '''
        sh'''
          cat cred_scanner.csv
        '''
        sh'''
          export application=ot-demo-ms
          export environment=dev
          export service=salary-api
          export organization=bp
          export source_key=gitleak 
          export report_file_path=null
          export base64EncodedResponse=`base64 cred_scanner.csv`
          envsubst < mi.template > cred_scanner.mi
          
          cat cred_scanner.mi
           
          curl -d "@cred_scanner.mi" -X POST  -H "Content-Type: application/json" http://34.131.67.101:9001/api/v1/maturity_dashboard/maturity_metrices/
        '''
    }

}
