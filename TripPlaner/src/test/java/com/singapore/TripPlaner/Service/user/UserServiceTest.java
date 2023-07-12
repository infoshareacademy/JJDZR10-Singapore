package com.singapore.TripPlaner.Service.user;

import com.singapore.TripPlaner.Model.User.User;
import com.singapore.TripPlaner.Model.User.UserRole;
import com.singapore.TripPlaner.Repository.UserRepository;
import com.singapore.TripPlaner.Service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    UserRepository userRepositoryMock;
    @InjectMocks
    private UserService userService;
    private User user = new User(
            "testUser",
            "Mockito",
            "test@wp.pl",
            "password",
            UserRole.USER,
            false,
            true
    );

    @Test
    void shouldReturnUserByUsername() {
        when(userRepositoryMock.findUserByLogin("testUser")).thenReturn(Optional.of(user));

        UserDetails testingUser = userService.loadUserByUsername("testUser");

        assertThat(testingUser).isEqualTo(user);
    }

}