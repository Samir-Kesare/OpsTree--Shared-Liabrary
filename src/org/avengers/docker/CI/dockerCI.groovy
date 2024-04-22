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

def trivyCheck() {
    stage('trivy Scan'){
    sh """
      sudo trivy image -q --severity HIGH,CRITICAL --exit-code 1 --format template --template '{{- $$critical := 0 }}{{- $$high := 0 }}{{- range . }}{{- range .Vulnerabilities }}{{- if  eq .Severity "CRITICAL" }}{{- $$critical = add $$critical 1 }}{{- end }}{{- if  eq .Severity "HIGH" }}{{- $$high = add $$high 1 }}{{- end }}{{- end }}{{- end }}Critical: {{ $$critical }}, High: {{ $$high }}' -o trivy-results.json salary-image:latest 
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
  }
}
