package org.avengers.docker.CI

def createImage(String imageName, String dockerfilePath) {
   //     id
  //     sudo systemctl restart docker
 //     groups jenkins
//     ls -l /var/run/docker.sock
    stage('Create Image'){
    sh """
        sudo docker build -t ${imageName} ${dockerfilePath}  
        sudo docker images
    """    
  }
}
// --exit-code 1
def trivyCheck() {
    stage('trivy Scan'){
    sh """
      sudo trivy image -q --severity HIGH,CRITICAL  --format template --template '{{- \$critical := 0 }}{{- \$high := 0 }}{{- range . }}{{- range .Vulnerabilities }}{{- if  eq .Severity "CRITICAL" }}{{- \$critical = add \$critical 1 }}{{- end }}{{- if  eq .Severity "HIGH" }}{{- \$high = add \$high 1 }}{{- end }}{{- end }}{{- end }}Critical: {{ \$critical }}, High: {{ \$high }}' -o trivy-results.json salary-image:latest 
    """
    sh '''
    awk 'BEGIN { FS="[:,]"; OFS="," }
    {
        for (i = 1; i <= NF; i += 2) {
            gsub(/ /, "", $i); # Remove spaces from keys
            header = (header ? header OFS : "") $i;
            value = (value ? value OFS : "") $(i+1);
        }
        print header > "mi.csv";
        print value >> "mi.csv";
    }' trivy-results.json
    '''  
    sh'''
    cat mi.csv
    ''' 
    sh'''
    export application=ot-demo-ms
    export environment=dev
    export service=salary-api
    export organization=bp
    export source_key=trivy
    export report_file_path=null
    export base64EncodedResponse=`base64 mi.csv`
    envsubst < mi.template > trivy.mi
    cat trivy.mi
    curl -d "@${trivy.mi}" -X POST  -H "Content-Type: application/json" http://34.131.67.101/api/v1/default/maturity_metrices/
    '''
  }
}
