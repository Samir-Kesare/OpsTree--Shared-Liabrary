def call() {
    stage("Bug Analysis") {
        steps {
            sh 'mvn compile'
            sh 'mvn spotbugs:spotbugs'
            sh 'mvn site'
        }
    }
}
