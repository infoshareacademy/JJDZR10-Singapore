package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    private final EmailService emailService;

    @Autowired
    public UserController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/registration")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        // TODO Dodać logikę rejestracji użytkownika
        String recipientEmail = "adres_odbiorcy@example.com";
        String confirmationCode = "12345";

        emailService.sendConfirmationEmail(recipientEmail, confirmationCode, username, password);

        // TODO Przekirować na stronę potwierdzenia rejestracji
        return "confirmation-page";
    }

}
