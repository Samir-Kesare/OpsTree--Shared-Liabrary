package org.avengers.terraform_CICD

def call(String rootPath, String childPath, String ACTION) {
    stage("Terraform Plan") {
        script {
            sh "cd ${rootPath}/${childPath} && terraform plan -out=tfplan.out"
        }
    }

    // stage('Want to Perform Terraform Apply') {
    //         when {
    //             expression { params.ACTION == 'Proceed' }
    //         }
    //         steps {
    //             // Prompt for approval before applying changes
    //             input "Do you want to apply Terraform changes?"
    //         }
    //     }
        
    //     stage('Review and Approve Destroy') {
    //         when {
    //             expression { params.ACTION == 'Abort' }
    //         }
    //         steps {
    //             // Prompt for approval before destroying resources
    //             input "Do you want to destroy Terraform resources?"
    //         }
    //     }

     stage('Want to Perform Terraform Apply') {
        script {
            if (ACTION == 'Proceed') {
                input "Do you want to apply Terraform changes?"
            }
        }
    }
    
    stage('Review and Approve Destroy') {
        script {
            if (ACTION == 'Abort') {
                input "Do you want to destroy Terraform resources?"
            }
        }
    }

    stage('Proceed or Abort') {
           // steps {
                script {
                    if (params.ACTION == 'Proceed') {
                        sh 'terraform apply "tfplan.out" -auto-approve'
                    } else if (params.ACTION == 'Abort') {
                         echo 'Failed!'
                    }
                }
          //  }
        }
    }

 //   stage("Terraform Apply") {
 //       script {
//            sh "cd ${rootPath}/${childPath} && terraform apply -auto-approve"
 //       }
//    }
//}



