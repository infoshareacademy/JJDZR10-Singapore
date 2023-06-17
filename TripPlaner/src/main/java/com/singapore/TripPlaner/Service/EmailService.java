package com.singapore.TripPlaner.Service;

import org.springframework.mail.javamail.JavaMailSender;

public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

}
