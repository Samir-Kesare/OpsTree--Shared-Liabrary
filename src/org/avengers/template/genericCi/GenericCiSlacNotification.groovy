package org.avengers.template.genericCi

import org.avengers.genericCi.slackNotification.*

def call(String url, String creds, String branch){
  dslJob = new DslJob()
  sendNotification = new SendNotification()

  dslJob .call()
  sendNotification.call()
}
