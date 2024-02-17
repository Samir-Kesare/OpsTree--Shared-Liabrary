package org.avengers.java.dependencyCheck

def call() {
    // Perform dependency check
    dependencyCheck additionalArguments: '--scan target/ --format ALL', odcInstallation: 'DP-check'
}
