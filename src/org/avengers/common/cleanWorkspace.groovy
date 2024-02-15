// Will not clean workspace if build is Sucessful and vice versa
package org.avengers.common

def call() {
  cleanWs cleanWhenSuccess: false
}
