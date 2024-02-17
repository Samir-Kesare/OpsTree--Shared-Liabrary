package org.avengers.java.dependencyCheck

def call() {
    // Perform dp check
    dependencyCheck additionalArguments: '--scan target/ --format ALL', odcInstallation: 'DP-check'
}
