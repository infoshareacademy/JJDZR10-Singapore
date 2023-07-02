package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Configuration.PasswordEncoder;
import com.singapore.TripPlaner.Model.User.User;
import com.singapore.TripPlaner.Service.EmailService;
import com.singapore.TripPlaner.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, EmailService emailService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/registration";
    }

    @PostMapping("/register")
    public String registrationUserAccount(@ModelAttribute User user) {
        user.setPassword(passwordEncoder.bCryptPasswordEncoder().encode(user.getPassword()));
        userService.registerNewUser(user);

        String recipientEmail = user.getEmail();
        String confirmationCode = "12345";

        emailService.sendConfirmationEmail(recipientEmail, confirmationCode, user.getName(), user.getPassword());

        return "redirect:/";
    }
}
