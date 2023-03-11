package com.infoshareacademy.service.emailService;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;


public class MailAuthenticator extends Authenticator {
    @Override
    protected PasswordAuthentication getPasswordAuthentication (){
        return new PasswordAuthentication("singaporejjdzr10@op.pl", "SingaporeJJDZR1)");

    }
}
