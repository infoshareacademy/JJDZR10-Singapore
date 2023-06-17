package com.singapore.TripPlaner.Service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendConfirmationEmail(String recipientEmail, String confirmationCode, String username, String password) {
        String subject = "Potwierdzenie rejestracji";
        String body = "Dziękujemy za rejestrację, " + username + "! Twój kod potwierdzający to: " + confirmationCode;

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(recipientEmail);
            helper.setSubject(subject);
            helper.setText(body);

            mailSender.send(message);

            System.out.println("Wysłano email potwierdzający rejestrację na adres: " + recipientEmail);

        } catch (MessagingException e) {
            System.out.println("Wystąpił błąd podczas wysyłania emaila: " + e.getMessage());
        }
    }
}
