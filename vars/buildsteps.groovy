def call() {
    return {
        stage('Build') {
            steps {
                script {
                    // Define the DSL for creating a Freestyle job
                    def jobDSL = '''
                        job('My-Freestyle-Job') {
                            description('This is a sample Freestyle job created using a Declarative Pipeline')
                            steps {
                                shell('echo "Hello, world!"')
                            }
                        }
                    '''
                    // Execute the job DSL to create the Freestyle job
                    jobDsl scriptText: jobDSL
                }
            }
        }
    }
}

