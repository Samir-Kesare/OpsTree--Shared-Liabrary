// Will not clean workspace if build is Sucessful and vice versa
def call() {
  cleanWs cleanWhenSuccess: false
}
