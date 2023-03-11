package com.infoshareacademy.service.emailService;

import java.util.Map;
import java.util.Properties;

public class MailConfiguration {

    public static Properties getConfiguration () {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.poczta.onet.pl");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.ssl.trust", "smtp.poczta.onet.pl");
        return prop;
    }
}
