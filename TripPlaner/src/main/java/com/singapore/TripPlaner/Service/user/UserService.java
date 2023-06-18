package com.singapore.TripPlaner.Service.user;

import com.singapore.TripPlaner.Model.User.User;
import com.singapore.TripPlaner.Model.User.UserRole;
import com.singapore.TripPlaner.Repository.UserRepository;
import lombok.AllArgsConstructor;
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
                .orElseThrow(()-> new UsernameNotFoundException("User not found with given user name " + username));
    }

    @Transactional
    public User registerNewUser(User user){
        if(emailExist(user.getEmail())){
            throw new UsernameNotFoundException("There is an account with that email: " + user.getEmail());
        } else if (!user.getPassword().equals(user.getMatchingPassword())) {
            throw new UsernameNotFoundException("Passwords are not matching");
        }
        user.setUserRole(UserRole.USER);
        userRepository.save(user);
        return user;
    }

    private boolean emailExist(String email){
        return userRepository.findUserByEmail(email).isPresent();
    }

}
