package org.avengers.template.genericCI

import org.avengers.genericCI.*

 def call(String url, String creds, String branch){
   slackNotification = new SlackNotification()

   slackNotification.call()
 }
