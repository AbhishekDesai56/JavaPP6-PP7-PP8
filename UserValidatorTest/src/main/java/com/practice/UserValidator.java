package com.practice;

import java.util.regex.Pattern;

public class UserValidator {

    private static final String NAME_PATTERN = "^[A-Z]{1}[a-z]{2,}$";
    private  static  final String EMAIL_ADDRESS_PATTERN = "^[0-9a-zA-Z]+([._+-][0-9a-zA-Z]+)*"+
                                                        "@([0-9a-zA-Z][-]?)+[.][a-zA-z]{2,4}([a-zA-z](2,4))?$";
    private static final String MOBILE_NO_PATTERN = "\\d{2}\\s\\d{10}";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    public boolean validateFirstName(String fname) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        return pattern.matcher(fname).matches();
    }

    public boolean validateEmailAddress(String email) {
        Pattern pattern = Pattern.compile(EMAIL_ADDRESS_PATTERN);
        return pattern.matcher(email).matches();
    }


    public boolean validateLastName(String lname) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        return pattern.matcher(lname).matches();
    }

    public boolean validateMobileNumber(String mobileNumber) {
        Pattern pattern = Pattern.compile(MOBILE_NO_PATTERN);
        return pattern.matcher(mobileNumber).matches();
    }

    public boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        return pattern.matcher(password).matches();
    }
}
