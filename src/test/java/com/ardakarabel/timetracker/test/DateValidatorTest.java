package com.ardakarabel.timetracker.test;

import com.ardakarabel.ttweb.validator.DateValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateValidatorTest {

    private DateValidator dateValidator;

    @Before
    public void init() {
        dateValidator = new DateValidator();
    }

    @Test
    public void testDateIsNull() {
        assertFalse(dateValidator.valid(null));
    }

    @Test
    public void testDayIsInvalid() {
        assertFalse(dateValidator.valid("32.02.2019 00:00"));
    }

    @Test
    public void testMonthIsInvalid() {
        assertFalse(dateValidator.valid("31.20.2019 00:00"));
    }

    @Test
    public void testYearIsInvalid() {
        assertFalse(dateValidator.valid("31.20.19991 00:00"));
    }

    @Test
    public void testDateFormatIsInvalid() {
        assertFalse(dateValidator.valid("2019.02.20 00:00"));
    }

    @Test
    public void testDateFeb29_2019() {
        assertTrue(dateValidator.valid("29.02.2016 00:00"));
    }

    @Test
    public void testDateFeb29_2011() {
        assertFalse(dateValidator.valid("29.02.2011 00:00"));
    }

    @Test
    public void testDateFeb28() {
        assertTrue(dateValidator.valid("28.02.2011 00:00"));
    }

    @Test
    public void testDateIsValid_1() {
        assertTrue(dateValidator.valid("31.01.2019 00:00"));
    }

    @Test
    public void testDateIsValid_2() {
        assertTrue(dateValidator.valid("30.04.2019 00:00"));
    }

    @Test
    public void testDateIsValid_3() {
        assertTrue(dateValidator.valid("31.05.2019 00:00"));
    }

    @Test
    public void testDateIsValid_4() {
        assertFalse(dateValidator.valid("31.05.2019 00-00"));
    }

    @Test
    public void testDateIsValid_5() {
        assertFalse(dateValidator.valid("31.05.2019 00-00"));
    }

    @Test
    public void testDateIsGreater_1() {
        assertTrue(dateValidator.validDiff("31.05.2019 00:00","31.05.2019 01:00"));
    }

    @Test
    public void testDateIsGreater_1_2() {
        assertFalse(dateValidator.validDiff("31.05.2019 00:00","31.05.2019 01-00"));
    }

    @Test
    public void testDateIsGreater_2() {
        assertFalse(dateValidator.validDiff("31.05.2019 01:00","31.05.2019 00:00"));
    }
}