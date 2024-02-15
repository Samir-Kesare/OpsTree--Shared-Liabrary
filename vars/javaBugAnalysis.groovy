def call() {
            sh 'mvn compile'
            sh 'mvn spotbugs:spotbugs'
            sh 'mvn site'
}
