// package org.avengers.terraform_CICD

// def call(String rootPath, String childPath) {
  
//   stage('Approval For Apply') {
//             script {
//                 // Prompt for approval before applying changes
//                 input "Do you want to Destroy Terraform Infrastructure?"
//             }
//         }  
  
//   stage('Terraform destroy') {
//         script {
//             sh "cd ${rootPath}/${childPath} && terraform destroy"
//         }
//     }
// }
package org.avengers.terraform_CICD

def call(String rootPath, String childPath, String ACTION) {
    stage('Approval For Destroy') {
        script {
            if (ACTION == 'destroy') {
                input "Do you want to Destroy Terraform Infrastructure?"
            }
        }
    }

    if (ACTION == 'destroy') {
        stage('Terraform destroy') {
            script {
                sh "cd ${rootPath}/${childPath} && terraform destroy --auto approve"
            }
        }
    }
}
