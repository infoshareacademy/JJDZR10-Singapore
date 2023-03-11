package com.infoshareacademy.service.emailService;

import jakarta.mail.Transport;
import jakarta.mail.internet.MimeMessage;

public class MailSender {
    public void mailSend (){
        try {
            MimeMessage message= MailPrepareService.prepareTextMessageObject("barteklubak@gmail.com", "Hello", "message");
            Transport.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
