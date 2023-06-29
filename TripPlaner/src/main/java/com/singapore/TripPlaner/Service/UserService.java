package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Model.User.User;
import com.singapore.TripPlaner.Model.User.UserRole;
import com.singapore.TripPlaner.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findUserByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with given user name " + username));
    }

    @Transactional
    public User registerNewUser(User user) {
        user.setUserRole(UserRole.USER); //TODO Zamiana przy tworzeniu administratora
        user.setLocked(false);
        user.setEnabled(true);
        userRepository.save(user);
        return user;
    }
}
