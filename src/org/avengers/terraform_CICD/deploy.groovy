package org.avengers.terraform_CICD

def call(String rootPath, String childPath, String ACTION) {
    stage("Terraform Plan") {
        script {
            sh "cd ${rootPath}/${childPath} && terraform plan"
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

    //  stage('Want to Perform Terraform Apply') {
    //     script {
    //         if (ACTION == 'Proceed') {
    //             input "Do you want to apply Terraform changes?"
    //         }
    //     }
    // }
    
    // stage('Review and Approve Destroy') {
    //     script {
    //         if (ACTION == 'Abort') {
    //             input "Do you want to destroy Terraform resources?"
    //         }
    //     }
    // }

    // stage('Proceed or Abort') {
    //        // steps {
    //             script {
    //                 if (params.ACTION == 'Proceed') {
    //                     sh 'terraform apply "tfplan.out" -auto-approve'
    //                 } else if (params.ACTION == 'Abort') {
    //                      echo 'Failed!'
    //                 }
    //             }
    //       //  }
    //     }
    // }

 //   stage("Terraform Apply") {
 //       script {
//            sh "cd ${rootPath}/${childPath} && terraform apply -auto-approve"
 //       }
//    }
//}

        stage('Approval For Apply') {
            when {
                expression { params.ACTION == 'apply' }
            }
            steps {
                // Prompt for approval before applying changes
                input "Do you want to apply Terraform changes?"
            }
        }
        stage('Terraform Apply') {
            when {
                expression { params.ACTION == 'apply' }
            }
            steps {
                // Run Terraform apply
                sh 'terraform apply -auto-approve'
            }
        }
        stage('Approval for Destroy') {
            when {
                expression { params.ACTION == 'destroy' }
            }
            steps {
                // Prompt for approval before destroying resources
                input "Do you want to Terraform Destroy?"
            }
        }
        stage('Terraform Destroy') {
            when {
                expression { params.ACTION == 'destroy' }
            }
            steps {
                // Destroy Infra
                sh 'terraform destroy -auto-approve'
            }
        }
   }
