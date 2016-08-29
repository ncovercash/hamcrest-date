package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.LocalTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.testng.annotations.Test;

/**
 * @author Stewart Bissett
 */
public class IsMaximumTest {

    private static final String ASSERTION_PATTERN = "\\s*Expected: the date is the maximum value for [A-Za-z ]*\\s*but: date is the [0-9]* [A-Za-z ]* instead of [0-9]* [A-Za-z ]*";

    // Date Matchers
    @Test
    public void isDateMaximum() {
        assertThat(AUG_31_2015_NOON_AS_DATE, DateMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateNotMaximum() {
        assertThat(AUG_01_2015_NOON_AS_DATE, DateMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateNull() {
        assertThat(AUG_01_2015_NOON_AS_DATE, DateMatchers.isMaximum((ChronoField) null));
    }

    // LocalDate Matchers
    @Test
    public void isLocalDateMaximum() {
        assertThat(AUG_31_2015, LocalDateMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNotMaximum() {
        assertThat(AUG_01_2015, LocalDateMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNull() {
        assertThat(AUG_01_2015, LocalDateMatchers.isMaximum((ChronoField) null));
    }

    // LocalDateTime Matchers
    @Test
    public void isLocalDateTimeMaximum() {
        assertThat(AUG_31_2015_NOON, LocalDateTimeMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotMaximum() {
        assertThat(AUG_01_2015_NOON, LocalDateTimeMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNull() {
        assertThat(AUG_01_2015_NOON, LocalDateTimeMatchers.isMaximum((ChronoField) null));
    }

    // ZonedDateTime Matchers
    @Test
    public void isZonedDateTimeMaximum() {
        assertThat(AUG_31_2015_NOON_UTC, ZonedDateTimeMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotMaximum() {
        assertThat(AUG_01_2015_NOON_UTC, ZonedDateTimeMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNull() {
        assertThat(AUG_01_2015_NOON_UTC, ZonedDateTimeMatchers.isMaximum((ChronoField) null));
    }

    // LocalTime Matchers
    @Test
    public void isLocalTimeMaximum() {
        assertThat(LocalTime.of(23, 0, 0), LocalTimeMatchers.isMaximum(ChronoField.HOUR_OF_DAY));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalTimeNotMaximum() {
        assertThat(LocalTime.of(22, 0, 0), LocalTimeMatchers.isMaximum(ChronoField.HOUR_OF_DAY));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalTimeNull() {
        assertThat(LocalTime.of(22, 0, 0), LocalTimeMatchers.isMaximum(null));
    }

}
