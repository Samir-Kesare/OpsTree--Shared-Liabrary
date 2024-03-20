// package org.avengers.Module_CI_CD

// def call(String rootPath, String childPath, String tagVersion) {
//     stage("Terraform action") {
//         script {
//             sh "cd ${rootPath}/${childPath}"
//         }
//     }
//     stage('Terraform init') {
//         script {
//             // Initialize Terraform working directory
//             sh "cd ${rootPath}/${childPath} && terraform init"
//         }
//     }
//     stage('Terraform fmt') {
//         script {
//             // Stage to format Terraform files
//             sh "cd ${rootPath}/${childPath} && sudo terraform fmt"
//         }
//     }
//     stage('Terraform Validate') {
//         script {
//             // Validate Terraform configurations
//             sh "cd ${rootPath}/${childPath} && sudo terraform validate"
//         }
//     }
//       stage('Static Code Analysis') {
//         script {
//             // Install TFLint and run static code analysis
//             sh "curl -s https://raw.githubusercontent.com/terraform-linters/tflint/master/install_linux.sh | sudo bash"
//             sh "cd ${rootPath}/${childPath} && tflint --format default | tee tflint_report.json"
//         }
//     }

//     stage('checkov') {
//         script {

//             // Check if Checkov is installed
//            def checkovInstalled = sh(script: 'test -x /var/lib/jenkins/.local/bin/checkov && echo "Installed"', returnStatus: true)
//             if (checkovInstalled == 0) {
//                echo "Checkov is already installed."
//            } else {
//                 echo "Checkov is not installed. Installing..."
//                 sh "pip install checkov"
//                 sh "python3 -m pip install checkov"
//                 sh 'echo "export PATH=\"`python3 -m site --user-base`/bin:\$PATH\"" >> ~/.bashrc'
//                 sh "sudo apt install pipenv -y"
//                 sh "pip install checkov"
                
//             }
//             // Stage to run Checkov for Terraform
//             sh "cd ${rootPath}/${childPath} && /var/lib/jenkins/.local/bin/checkov -d . -s --output-file-path . --skip-path ./tflint_report.jsonֿ"
//         }
//     }
//     stage("Terraform Plan") {
//         script {
//             sh "cd ${rootPath}/${childPath} && terraform plan"
//         }
//     }
    
//    stage('Git Tag Stage') {
//         script {
//             // Tag the version
//             sh "git tag -a v${tagVersion} -m 'Version ${tagVersion}'"
//         }
//     }
// }

package org.avengers.Module_CI_CD

def call(boolean runTerraformAction, boolean runTerraformInit, boolean runTerraformFmt, boolean runTerraformValidate, boolean runStaticCodeAnalysis, boolean runCheckov, boolean runTerraformPlan, boolean runGitTag, String rootPath, String childPath, String tagVersion) {
    if (runTerraformAction) {
        stage("Terraform action") {
            script {
                sh "cd ${rootPath}/${childPath}"
            }
        }
    }
    if (runTerraformInit) {
        stage('Terraform init') {
            script {
                // Initialize Terraform working directory
                sh "cd ${rootPath}/${childPath} && terraform init"
            }
        }
    }
    if (runTerraformFmt) {
        stage('Terraform fmt') {
            script {
                // Stage to format Terraform files
                sh "cd ${rootPath}/${childPath} && sudo terraform fmt"
            }
        }
    }
    if (runTerraformValidate) {
        stage('Terraform Validate') {
            script {
                // Validate Terraform configurations
                sh "cd ${rootPath}/${childPath} && sudo terraform validate"
            }
        }
    }
    if (runStaticCodeAnalysis) {
        stage('Static Code Analysis') {
            script {
                // Install TFLint and run static code analysis
                sh "curl -s https://raw.githubusercontent.com/terraform-linters/tflint/master/install_linux.sh | sudo bash"
                sh "cd ${rootPath}/${childPath} && tflint --format default | tee tflint_report.json"
            }
        }
    }
    if (runCheckov) {
        stage('checkov') {
            script {
                // Check if Checkov is installed
                def checkovInstalled = sh(script: 'test -x /var/lib/jenkins/.local/bin/checkov && echo "Installed"', returnStatus: true)
                if (checkovInstalled == 0) {
                    echo "Checkov is already installed."
                } else {
                    echo "Checkov is not installed. Installing..."
                    sh "pip install checkov"
                    sh "python3 -m pip install checkov"
                    sh 'echo "export PATH=\"`python3 -m site --user-base`/bin:\$PATH\"" >> ~/.bashrc'
                    sh "sudo apt install pipenv -y"
                    sh "pip install checkov"
                }
                // Stage to run Checkov for Terraform
                sh "cd ${rootPath}/${childPath} && /var/lib/jenkins/.local/bin/checkov -d . -s --output-file-path . --skip-path ./tflint_report.json"
            }
        }
    }
    if (runTerraformPlan) {
        stage("Terraform Plan") {
            script {
                sh "cd ${rootPath}/${childPath} && terraform plan"
            }
        }
    }
    if (runGitTag) {
        stage('Git Tag Stage') {
            script {
                // Tag the version
                sh "git tag -a v${tagVersion} -m 'Version ${tagVersion}'"
            }
        }
    }
}
