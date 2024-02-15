// Define the function for the Test stage
def call() {
             echo "Executing Java Unit Testing"
             sh 'mvn test'
}
