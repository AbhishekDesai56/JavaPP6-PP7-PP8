package com.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserMobileTest {
    @Test
    public void givenMobileNumber_WhenProper_ShouldReturnTrue() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateMobileNumber("91 9919819801");
        Assertions.assertTrue(result);
    }
}
