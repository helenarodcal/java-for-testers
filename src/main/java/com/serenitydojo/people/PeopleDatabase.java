package com.serenitydojo.people;

import java.util.ArrayList;
import java.util.List;

public class PeopleDatabase {
    List<Person> allThePeople;
    public PeopleDatabase(List<Person> allThePeople) {
        this.allThePeople = allThePeople;
    }

    public List<Person> findPeopleUnder35(PeopleDatabase people) {
        List<Person> peopleUnder35 = new ArrayList<>();
        for(Person person : allThePeople) {
            if(person.getAge() < 35) {
                peopleUnder35.add(person);
            }
        }
        return peopleUnder35;
    }

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
}
