package com.practice;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UserEmailTest {
    private String email2Test;
    private boolean expectedResult;

    public void validateEmailTest(String email, boolean expectedResult) {
        this.email2Test = email;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][] {
                {"abc@yahoo.com", true},
                {"abc@yahoo.com", true},
                {"abc-100@yahoo.com", true},
                {"abc.100@yahoo.com", true},
                {"abc111@abc.com", true},
                {"abc-100@abc.net", true},
                {"abc@yahoo.com", true},
                {"abc@yahoo.com", true},
                {"abc@yahoo.com", true},
                {"abc@yahoo.com", true},
                {"abc@yahoo.com", true}
        });
    }

    @Test
    public void givenValidator_ShouldReturnAsPerTheParameterizedResult() {
        UserValidator validator = new UserValidator();
        boolean result = validator.validateEmailAddress(this.email2Test);
        Assertions.assertEquals(this.expectedResult, result);
    }
}
