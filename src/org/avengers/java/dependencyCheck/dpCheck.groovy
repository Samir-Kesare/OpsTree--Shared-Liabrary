package org.avengers.java.dependencyCheck

def call() {
    stage('Dependency Check') {
        // Perform dp check
        dependencyCheck additionalArguments: '--scan target/ --format ALL', odcInstallation: 'DP-check'
    }
}
