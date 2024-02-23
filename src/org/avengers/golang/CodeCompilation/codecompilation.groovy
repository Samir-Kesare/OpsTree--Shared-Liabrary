package org.avengers.golang.CodeCompilation

def call() {
  echo "Golang code compilation"
   sh "go list -f '{{.Target}}'"
}
return this
