package com.kat.recruitapp.validators.password;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwaspPasswordValidatorTest {


    private final OwaspPasswordValidator validator = new OwaspPasswordValidator();

    @Test
    public void testValidPassword() {
        assertTrue(validator.isValid("StrongPassword1@", null));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(validator.isValid("weakpassword", null));
    }

    @Test
    public void testNullPassword() {
        assertFalse(validator.isValid(null, null));
    }

}