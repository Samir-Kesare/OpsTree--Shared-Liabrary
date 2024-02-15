// Checkout Github Public Repository
package org.avengers.common

def call(Map config = [:]) {
            checkout scm: [
                $class: 'GitSCM',
                branches: [[name: config.branch]],
                userRemoteConfigs: [[url: config.url]]
            ]
}
