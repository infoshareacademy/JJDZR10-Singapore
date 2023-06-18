package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.User.User;
import com.singapore.TripPlaner.Service.user.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


//    private final UserService userService;
//    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    public UserController(UserService userService, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userService = userService;
//        this.userRepository = userRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//    public void registerUser(User user) {
//        boolean userExist = userRepository.findUserByLogin(user.getLogin()).isPresent();
//        if (userExist) {
//            throw new UserFindException("User %s is already register" + user.getLogin());
//        }
//        String encodePassword = bCryptPasswordEncoder.encode(user.getPassword());
//        user.setPassword(encodePassword);
//        userService.register(user);
//    }

    @GetMapping("/user/registration")
    public String registration (Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "user/registration";
    }

    @PostMapping("user/registration")
    public String registrationUserAccount(@ModelAttribute User user){
//        try {
            userService.registerNewUser(user);
//        } catch (UsernameNotFoundException u){
//            return "/invalidMail";
//        }
        return "home";
    }

}
