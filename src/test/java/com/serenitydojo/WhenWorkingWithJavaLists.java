package com.serenitydojo;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class WhenWorkingWithJavaLists {

    @Test
    public void listOfColors() {

        //ARRAYS: once defined you cannot add elements --> length is needed from the beginning
        String[] color = {"red", "green", "blue"};
        int[] ages = {1, 2, 3, 4};

        String[] moreColors = new String[3];

        moreColors[0] = "yellow";
        moreColors[1] = "purple";
        moreColors[2] = "pink";

        for ( int i = 0; i < moreColors.length; i++ ) {
            System.out.println("Color number " + i+1 + " is " + moreColors[i]);
        }

        //LISIS: are classes --> they have more methods to manipulat
        // lists can have repeated items
        List<String> myColors = new ArrayList<>();

        myColors.add("red");
        myColors.add("blue");
        myColors.add("purple");
        myColors.add("red"); //--> will be included

        String firstMyColor = myColors.get(0);

        for( String someColor : myColors) {
            System.out.println("My Color is " + someColor);
        }

        //SETS: cannot have repeated items
//        They don't maintain the order

        Set<String> uniqueColors = new HashSet<>();

        uniqueColors.add("red");
        uniqueColors.add("blue");
        uniqueColors.add("purple");
//        uniqueColors.add("red"); //--> WON'T be included

        for( String someColor : uniqueColors) {
            System.out.println("Unique color is " + someColor);
        }

    }

   @Test
   public void creating_a_simple_list() {

        //allows elements of different types
        List simpleList = new ArrayList<>();
        simpleList.add("a string value");
        simpleList.add(123);

       assertThat(simpleList).contains("a string value", 123);
   }

   @Test
    public void create_a_typed_list() {
        //only allows elements of a specific type
        List<String> names = new ArrayList<>();

        names.add("John");
        names.add("Sally");
        names.add("Pete");

        List<Integer> ages = Arrays.asList(10, 30, 50);

        assertThat(names).contains("John", "Sally", "Pete");
        assertThat(ages).contains(10,30,50);

        //includes all types of numbers
        List<Number> favoriteNumbers = Arrays.asList(10, 30, 50, 10000000000L, 3.14245423);
        assertThat(favoriteNumbers).contains(10, 30, 50, 10000000000L, 3.14245423);
   }

   @Test
    public void remove_stuff() {
       List<String> names = new ArrayList<>();

       names.add("John");
       names.add("Sally");
       names.add("Pete");

       names.remove("Pete");

       assertThat(names).contains("John", "Sally");

       names.clear();

       assertThat(names).isEmpty();
   }

    @Test
    public void updating_immutable_lists() {
        //Arrays and arrays.aslists are constant collections
//        cannot add or remove items
        List<Integer> ages = Arrays.asList(10, 30, 50);

        ages.remove(1);
        ages.add(10);
    }

    @Test
    public void combine_lists() {
        List<String> names = new ArrayList<>();

        names.add("John");
        names.add("Sally");
        names.add("Pete");

        List<String> moreNames = new ArrayList<>();
        moreNames.add("Paul");
        moreNames.add("Petra");

        names.addAll(moreNames);
        assertThat(names).contains("John","Sally", "Pete", "Paul", "Petra");

        names.removeAll(moreNames);
        assertThat(names).contains("John","Sally", "Pete");
    }

    @Test
    public void find_element_in_a_list() {

        List<String> names = Arrays.asList("joe", "sally", "pete", "sally", "paul");

        int indexOfSally = names.indexOf("sally");
        int lastIndexOfSally = names.lastIndexOf("sally");

        assertThat(indexOfSally).isEqualTo(1);
        assertThat(lastIndexOfSally).isEqualTo(3);
    }

    @Test
    public void find_a_sublist() {

        List<String> names = Arrays.asList("joe", "sally", "pete", "sally", "paul");

        List<String> middleNames = names.subList(1,4);
        assertThat(names).contains("sally", "pete", "sally");
    }

    @Test
    public void find_size() {

        List<String> names = Arrays.asList("joe", "sally", "pete", "sally", "paul");

        assertThat(names.size()).isEqualTo(5);
    }

    @Test
    public void converting_a_list_to_a_set() {
        //elements cannot be repeated
        //elements do not respect the creation order
        List<String> names = Arrays.asList("joe", "sally", "pete", "sally", "paul");

        Set<String> uniqueNames = new HashSet<>(names);

        assertThat(uniqueNames).containsExactlyInAnyOrder("joe", "sally", "pete", "paul");
    }

    @Test
    public void sorting_a_list() {
        List<String> names = Arrays.asList("joe", "sally", "pete", "sally", "paul");

        Collections.sort(names);

        assertThat(names).containsExactly("joe", "paul", "pete", "sally", "sally");
    }

    @Test
    public void finding_max_and_min() {
        List<Integer> ages = Arrays.asList(10, 30, 50, 20, 15);

        assertThat(Collections.max(ages)).isEqualTo(50);
        assertThat(Collections.min(ages)).isEqualTo(10);
    }
}
