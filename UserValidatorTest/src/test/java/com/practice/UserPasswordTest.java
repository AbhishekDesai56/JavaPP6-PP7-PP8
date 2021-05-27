package com.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserPasswordTest {
    @Test
    public void givenPassword_WhenProper_ShouldReturnTrue() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validatePassword("Abhishek@123");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenPassword_WhenNotProper_ShouldReturnFalse() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validatePassword("@@1222");
        Assertions.assertFalse(result);
    }
}
