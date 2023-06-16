package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.User.User;
import com.singapore.TripPlaner.Service.user.RegistrationService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private final RegistrationService registrationService;

    public UserController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    public String register (User user){
        return registrationService.register(user);
    }

}
