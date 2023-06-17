package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Service.EmailService;

public class UserController {

    private final EmailService emailService;

    public UserController(EmailService emailService) {
        this.emailService = emailService;
    }

}
