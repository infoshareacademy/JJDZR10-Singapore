package com.singapore.TripPlaner.Service.user;

import com.singapore.TripPlaner.Model.User.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        User user = new User();
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
