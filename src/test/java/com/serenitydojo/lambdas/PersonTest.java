package com.serenitydojo.lambdas;

import com.serenitydojo.people.Gender;
import com.serenitydojo.people.PeopleDatabase;
import com.serenitydojo.people.Person;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class PersonTest {

    Person sam = new Person("Samantha", Gender.FEMALE, 30, "Yellow");
    Person bill = new Person("Bill", Gender.MALE, 40, "Blue");
    Person tim = new Person("Timothy", Gender.MALE, 10, "Red");
    Person susan = new Person("Susan", Gender.FEMALE, 35, "Red");

    List<Person> allThePeople = Arrays.asList(sam, bill, tim, susan);

    @Test
    public void i_can_create_some_people() {

        //we need a method in the person class called toString to return a meaningful value
        System.out.println(allThePeople);
    }

    @Test
    public void i_can_search_for_peple_by_age() {

        PeopleDatabase people = new PeopleDatabase(allThePeople);

        List<Person> peopleUnder35 = people.findPeopleUnder35(people);

        System.out.println(peopleUnder35);
        assertThat(peopleUnder35).contains(sam, tim);
    }

    @Test
    public void i_can_search_for_peple_by_favorite_color() {

        PeopleDatabase people = new PeopleDatabase(allThePeople);

        List<Person> peopleWhoLikeRed = people.findPeopleWhoLikeRed(people);

        System.out.println(peopleWhoLikeRed);
        assertThat(peopleWhoLikeRed).contains(tim, susan);
    }

    @Test
    public void i_can_search_for_people_between_20_and_40() {

        PeopleDatabase people = new PeopleDatabase(allThePeople);

        List<Person> peopleBetween20And40 = people.findPeopleBetween(20, 40);

        System.out.println(peopleBetween20And40);
        assertThat(peopleBetween20And40).contains(sam, susan);
    }
}
