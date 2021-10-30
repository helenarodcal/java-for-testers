package com.serenitydojo;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.*;

public class WhenWorkingWithDates {

    @Test
    public void creating_a_timestamp_for_today() {

        LocalDate today = LocalDate.now();
        System.out.println("Today is " + today);
    }

    @Test
    public void create_a_given_date () {

        LocalDate fourthOfJuly = LocalDate.of(2021, 7, 4);
        System.out.println(fourthOfJuly);
    }

    @Test
    public void parsing_a_date() {

        String dateInStringForm = "2021-05-01";
        LocalDate firstOfMay = LocalDate.parse(dateInStringForm);
        System.out.println(firstOfMay);
    }

    @Test
    public void parsing_a_date_with_a_given_format() {

        String dateInStringForm = "01/05/2021";
        LocalDate mayFirst = LocalDate.parse(dateInStringForm, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println(mayFirst.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
    }

    @Test
    public void yesterday() {

       LocalDate today = LocalDate.now();
//       LocalDate yesterday = today.minusDays(1);

       LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
       LocalDate oneCenturyAgo = today.minus(1, ChronoUnit.CENTURIES);

        System.out.println(yesterday.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
        System.out.println(oneCenturyAgo.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
    }

    @Test
    public void checking_the_month() {

        LocalDate today = LocalDate.now();

        System.out.println(today.getYear());
        System.out.println(today.getMonth());
        System.out.println(today.getDayOfMonth());

        assertThat(today.getMonth()).isGreaterThan(Month.SEPTEMBER);
    }

    @Test
    public void comparing_dates() {

        LocalDate firstOfMay = LocalDate.of(2021, 5, 1);
        LocalDate fifthOfMay = LocalDate.of(2021, 5, 5);
        LocalDate tenthOfMay = LocalDate.of(2021, 5, 10);

        assertThat(firstOfMay).isEqualTo("2021-05-01");
        assertThat(firstOfMay).isBefore(fifthOfMay);
//        assertThat(firstOfMay).isAfter(fifthOfMay);//fails
        assertThat(fifthOfMay).isBetween(firstOfMay, tenthOfMay);
    }

    @Test
    public void using_times() {
        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalTime infiveHoursTime = now.plus(5, ChronoUnit.HOURS);
        System.out.println(infiveHoursTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        LocalTime halfADayAgo = now.minus(1, ChronoUnit.HALF_DAYS);
        System.out.println(halfADayAgo.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
    }
}
