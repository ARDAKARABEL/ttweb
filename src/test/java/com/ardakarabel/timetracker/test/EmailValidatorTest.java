package com.ardakarabel.timetracker.test;

import com.ardakarabel.ttweb.validator.EmailValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmailValidatorTest {

    private EmailValidator emailValidator;

    @Before
    public void init() {
        emailValidator = new EmailValidator();
    }

    @Test
    public void testEmailIsNull() {
        assertFalse(emailValidator.valid(null));
    }

    @Test
    public void testEmailValid_1() {
        assertTrue(emailValidator.valid("arda@karabel.tk"));
    }

    @Test
    public void testEmailValid_2() {
        assertTrue(emailValidator.valid("ardakarabel@gmail.com"));
    }

    @Test
    public void testEmailValid_3() {
        assertTrue(emailValidator.valid("ardakarabel@gmail.com"));
    }

    @Test
    public void testEmailValid_4() {
        assertFalse(emailValidator.valid("ardakarabel!gmail.com"));
    }

    @Test
    public void testEmailValid_5() {
        assertTrue(emailValidator.valid("a@b.com"));
    }

}