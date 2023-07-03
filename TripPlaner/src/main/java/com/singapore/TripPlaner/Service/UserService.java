package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Model.User.User;
import com.singapore.TripPlaner.Model.User.UserRole;
import com.singapore.TripPlaner.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findUserByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with given user name " + username));

    }

    @Transactional
    public User registerNewUser(User user) {
        user.setUserRole(UserRole.USER);
        user.setLocked(false);
        user.setEnabled(true);
        userRepository.saveAndFlush(user);
        return user;
    }

    public boolean checkUserLoginAndMailIsPresentInDb(User user) {
        return userRepository.findUserByEmail(user.getEmail()).isPresent() || userRepository.findUserByLogin(user.getLogin()).isPresent();

    }
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return (User) authentication.getPrincipal();
    }

}
