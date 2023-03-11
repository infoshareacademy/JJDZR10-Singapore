package com.infoshareacademy.service.emailService;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class MailPrepareService extends  Authenticator{

    private static MimeMessage prepareMessageObject (String recipient, String subject) throws Exception {
        Properties properties = MailConfiguration.getConfiguration();
        MailAuthenticator authenticator = new MailAuthenticator();

        Session session = Session.getInstance(properties, authenticator);

        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setSubject(subject, "UTF-8");
        PasswordAuthentication passwordAuthentication = authenticator.getPasswordAuthentication();
        mimeMessage.setFrom(passwordAuthentication.getUserName());
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        return mimeMessage;
    }
    public static MimeMessage prepareTextMessageObject (String recipient, String subject, String content) throws Exception {
        MimeMessage textMessage = prepareMessageObject(recipient, subject);
        textMessage.setText(content);
        return textMessage;
    }
}
