package org.avengers.common

def call() {
    // package artifacts minus the testing
    sh 'mvn clean package -DskipTests=true'
}
