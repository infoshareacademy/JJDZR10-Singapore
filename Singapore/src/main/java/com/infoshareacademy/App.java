package com.infoshareacademy;
import com.infoshareacademy.model.User;
import com.infoshareacademy.service.Menu;
import com.infoshareacademy.service.OpinionService;
import com.infoshareacademy.service.emailService.MailSender;


public class App {
    public static void main(String[] args) {

        MailSender mailSender = new MailSender();
        mailSender.mailSend();

    }
}
