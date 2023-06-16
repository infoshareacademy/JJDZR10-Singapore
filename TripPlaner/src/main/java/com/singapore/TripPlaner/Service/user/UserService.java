package com.singapore.TripPlaner.Service.user;

import com.singapore.TripPlaner.Model.User.User;
import com.singapore.TripPlaner.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

private final UserRepository userRepository;
    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findUserByLogin(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found with given user name " + username));
    }
}
