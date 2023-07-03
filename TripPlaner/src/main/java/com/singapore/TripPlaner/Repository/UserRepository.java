package com.singapore.TripPlaner.Repository;

import com.singapore.TripPlaner.Model.User.User;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByLogin(String login);
    Optional<User> findUserByEmail(String email);
}
