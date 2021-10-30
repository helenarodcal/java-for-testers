package com.serenitydojo.lambdas;

import com.serenitydojo.people.*;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class PersonTest {

    Person sam = new Person("Samantha", Gender.FEMALE, 29, "Green");
    Person bill = new Person("Bill", Gender.MALE, 40, "Blue");
    Person tim = new Person("Timothy", Gender.MALE, 10, "Red");
    Person susan = new Person("Susan", Gender.FEMALE, 35, "Red");
    Person sarah = new Person("Sarah", Gender.FEMALE, 50, "Orange");
    Person paul = new Person("Paul", Gender.MALE, 50, "Blue");


    List<Person> allThePeople = Arrays.asList(sam, bill, tim, susan, sarah, paul);

//    PersonChecker LIKE_BLUE = person -> person.getFavouriteColor().equals("Blue");
//    PersonChecker LIKE_RED_OR_UNDER_30
//            = person -> person.getFavouriteColor().equals("Red") || person.getAge() <= 30;
    Predicate<Person> LIKE_BLUE = person -> person.getFavouriteColor().equals("Blue");
    Predicate<Person> LIKE_GREEN = person -> person.getFavouriteColor().equals("Green");
    Predicate<Person> LIKE_RED = person -> person.getFavouriteColor().equals("Red");
    Predicate<Person> LIKE_RED_OR_UNDER_30
            = person -> person.getFavouriteColor().equals("Red") || person.getAge() <= 30;
    Predicate<Person> UNDER_35 = person -> person.getAge() < 35;

    @Test
    public void i_can_create_some_people() {

        //we need a method in the person class called toString to return a meaningful value
        System.out.println(allThePeople);
    }

    @Test
    public void i_can_search_for_peple_by_age() {

        PeopleDatabase people = new PeopleDatabase(allThePeople);

//        List<Person> peopleUnder35 = people.findPeopleUnder35(people);
        List<Person> peopleUnder35 = people.findAllThePeopleWho(UNDER_35);

        System.out.println(peopleUnder35);
        assertThat(peopleUnder35).contains(sam, tim);
    }

    @Test
    public void i_can_search_for_people_by_favorite_color() {

        PeopleDatabase people = new PeopleDatabase(allThePeople);

//        List<Person> peopleWhoLikeRed = people.findPeopleWhoLikeRed(people);
        List<Person> peopleWhoLikeRed = people.findAllThePeopleWho(LIKE_RED);

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

    @Test
    public void i_can_search_for_people_who_like_red_or_who_are_under_30() {
        PeopleDatabase people = new PeopleDatabase(allThePeople);

//        LikeRedOrUnder30 likeRedOrUnder30 = new LikeRedOrUnder30();

        List<Person> matchingPeople
                = people.findAllThePeopleWho(LIKE_RED_OR_UNDER_30);

        assertThat(matchingPeople).contains(sam, tim, susan);
    }

    @Test
    public void i_can_search_for_people_who_like_green() {
        PeopleDatabase people = new PeopleDatabase(allThePeople);

//        LikeGreen likeGreen = new LikeGreen();

        List<Person> matchingPeople
                = people.findAllThePeopleWho(LIKE_GREEN);

        assertThat(matchingPeople).contains(sam);
    }

    @Test
    public void i_can_search_for_people_who_like_blue() {
        PeopleDatabase people = new PeopleDatabase(allThePeople);

        //instead of creating a class to implement the personchecker interface everytime we test a new condition
        //we can create an anonymous class (class on the fly) that implements the interface inside the method
//        PersonChecker likeBlue = new PersonChecker() {
//            @Override
//            public boolean test(Person person) {
//                return person.getFavouriteColor().equals("Blue");
//            }
//        };
        //you can convert the anonymous class to a lambda expression
        //and we can even create an enumerate with the condition to be met (at the beginning of the class)
        //and remove this
//       PersonChecker likeBlue = person -> person.getFavouriteColor()equals("Blue");


        List<Person> matchingPeople
//                = people.findAllThePeopleWho(likeBlue);
                    = people.findAllThePeopleWho(LIKE_BLUE);

        assertThat(matchingPeople).contains(bill);
    }

    @Test
    public void people_can_earn_points() {
//        allThePeople.parallelStream().forEach(
//                person -> {
//                    person.earnPoints(100);
//                    System.out.println("POINTS for " + person.getName() + " = " + person.getPoints());
//                }
//
//        );
        allThePeople.stream()
                //peek is a consumer: similar to a void method
                .peek(person -> System.out.println("POINTS for " + person.getName() + " = " + person.getPoints()))
                .peek(person -> person.earnPoints(100))
                .forEach(person -> System.out.println("UPDATED POINTS for " + person.getName() + " = " + person.getPoints()));

//        allThePeople.forEach(
//                person -> System.out.println("POINTS for " + person.getName() + " = " + person.getPoints())
//        );
    }

    @Test
    public void find_all_colours_of_people() {
        //map is a function: it returns a value (in this case, a new list of colours)
        List<String> allTheColours = allThePeople.stream()
//                .map(person -> person.getFavouriteColor())
                .map(Person::getFavouriteColor)
//                .sorted() //this sorts in natural order (for strings is alphabetic)
//                .sorted(Comparator.reverseOrder())
                .sorted(Comparator.comparing((color) -> color.length())) //you can create your own comparison function
                .distinct() //removes duplicates
                .collect(Collectors.toList());

        System.out.println(allTheColours);
    }

    @Test
    public void find_sum_of_letters_of_all_colours() {
        int totalNumberOfLetters = allThePeople.stream()
//                .map(person -> person.getFavouriteColor())
                .map(Person::getFavouriteColor)
                .sorted()
                .distinct() //removes duplicates
                .mapToInt(colour -> colour.length())
                        .sum();


        System.out.println(totalNumberOfLetters);
    }

    @Test
    public void find_min_of_letters_of_all_colours() {
        //by the time we get to the min, the list could be empty and min or max cannot be calculated
        OptionalInt minNumberOfLetters = allThePeople.stream()

                .map(Person::getFavouriteColor)
//                .filter(colour -> colour.equals("Fuchsia")) // this would return an empty list
                .filter(colour -> colour.equals("Red") || colour.equals("Blue"))
                .sorted()
                .distinct() //removes duplicates
                .mapToInt(colour -> colour.length())
                .min();


        System.out.println(minNumberOfLetters);
    }
}
