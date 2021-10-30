package com.serenitydojo.people;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * The only thing this class finally does is:
 * taking a list of persons: allThePeople
 * and filtering and returning those who meet the conditions defined in the predicates
 */
public class PeopleDatabase {
    List<Person> allThePeople;
    public PeopleDatabase(List<Person> allThePeople) {
        this.allThePeople = allThePeople;
    }
    /*
    Not needed anymore because we implemented a predicate
     */
    public List<Person> findPeopleUnder35(PeopleDatabase people) {
        List<Person> peopleUnder35 = new ArrayList<>();
        for(Person person : allThePeople) {
            if(person.getAge() < 35) {
                peopleUnder35.add(person);
            }
        }
        return peopleUnder35;
    }

    /*
    Not needed anymore because we implemented a predicate
     */
    public List<Person> findPeopleWhoLikeRed(PeopleDatabase people) {
        List<Person> peopleWhoLikeRed = new ArrayList<>();
        for(Person person : allThePeople) {
            if(person.getFavouriteColor().equals("Red")) {
                peopleWhoLikeRed.add(person);
            }
        }
        return peopleWhoLikeRed;
    }

    public List<Person> findPeopleBetween(int lowestAge, int highestAge) {
        List<Person> matchingPeople = new ArrayList<>();
        for (Person person : allThePeople) {
            if (person.getAge() >= lowestAge && person.getAge() <= highestAge) {
                matchingPeople.add(person);
            }
        }
        return matchingPeople;
    }

//    public List<Person> findAllThePeopleWho(PersonChecker check) {
    public List<Person> findAllThePeopleWho(Predicate<Person> check) {
//        List<Person> matchingPeople = new ArrayList<>();
//        for (Person person : allThePeople) {
//            //we don't need to check the details of the condition. LikeRedOrUnder30 object does it for us
//            if (check.test(person)) {
//                matchingPeople.add(person);
//            }
//        }
//
//        return matchingPeople;

        //if we use streams the code gets very concise
        return allThePeople.stream()
                .filter(check)
                .collect(Collectors.toList());
    }
}
