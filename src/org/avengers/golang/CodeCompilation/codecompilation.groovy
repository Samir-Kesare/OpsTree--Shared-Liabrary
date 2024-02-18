package org.org.avengers.golang.CodeCompilation

def call() {
  echo "Golang code compilation"
   sh 'go install'
   sh "go list -f '{{.Target}}'"
}
return this
