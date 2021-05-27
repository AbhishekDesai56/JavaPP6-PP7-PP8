package com.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserValidatorTest {
    @Test
    public void givenFirstName_WhenProper_ShouldReturnTrue() {
       UserValidator validator = new UserValidator();
       boolean result = validator.validateFirstName("Abhishek");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenFirstName_WhenProper_ShouldReturnFalse() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateFirstName("Ab");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenFirstName_WhenWithSpChars_ShouldReturnFalse() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateFirstName("@bhishek");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenLastName_WhenProper_ShouldReturnTrue() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateLastName("Desai");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenLastName_WhenProper_ShouldReturnFalse() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateLastName("De");
        Assertions.assertFalse(result);
    }

    @Test
    public void givenLastName_WhenWithSpChars_ShouldReturnFalse() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateLastName("@bhishek");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenEmail_WhenValid_ShouldReturnTrue() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateEmailAddress("Abhishek-100@gmail.com");
        Assertions.assertTrue(result);
    }


}
