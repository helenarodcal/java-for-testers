package com.serenitydojo.lambdas;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WhenUsingLambdas {

    @Test
    public void printingOutColors() {
        List<String> colors = Arrays.asList("red", "green", "blue");

        for(String color : colors) {
            System.out.println("COLOR: " + color);
        }

        //lambda expressions are equivalent to converting to function
//        for(String color : colors) {
//            printColors(color);
//        }
//
        //for each element in the collection --> call a method
        colors.forEach(
                color -> printColors(color)
//              this::printColors
        );
        //or do some action
        colors.forEach(
                color -> {
                    if (color.equals("red"))
                            System.out.println("RED!");
                    else
                        System.out.println(color);
                }
        );

        //you cannot assign a method to a variable in Java (you can in Js)
//        var myVar = printColors("red"");
//        but you can assign a static method in the class
        colors.forEach(
              WhenUsingLambdas::staticPrintColors
        );

    }
    public void printColors(String color) {
        System.out.println("COLOR: " + color);
    }
    public static void staticPrintColors(String color) {
        System.out.println("COLOR: " + color);
    }

    @Test
    public void filteringColors() {
        List<String> colors = Arrays.asList("red", "green", "blue", "grey", "raspberry", "rose");

        //use stream and filter values on some condition
//        colors.stream()
//                .filter(color -> color.startsWith("g")) //--> result of the filter needs to be a boolean
//                .forEach(color -> System.out.println("COLOR: " + color));
//
//        }

        //you can collect the filtered colors in a new collection (list) and then manipulate it
        List<String> filteredColors = colors.stream()
                .filter(color -> color.startsWith("r"))
                //convert to a different object. Eg. take webpage and turn it to string
                .map(color -> color.toUpperCase())
                .sorted()
                .collect(Collectors.toList());
        System.out.println(filteredColors);

        List<Integer> lengthOfColors = colors.stream()
                .filter(color -> color.startsWith("r"))
                //convert to a different object. Eg. take webpage and turn it to string
                .map(color -> color.length()) //--> we are now returning a list of integers and we need to change it
                .sorted()
                .collect(Collectors.toList());
        System.out.println(lengthOfColors);

        List<String> sameColors = Arrays.asList("red", "green", "blue", "grey", "raspberry", "rose");
        Optional<Integer> minLength = sameColors.stream()
                .filter(otherColor -> otherColor.startsWith("n"))
                //convert to a different object. E.g. take webpage and turn it to string
                .map(otherColor -> otherColor.length()) //--> we are now returning a list of integers and we need to change it
                .sorted()
                .findFirst();
        //cannot directly do a get to manipulate the result value because OPTIONAL can be empty
//        System.out.println(minLength.get()); //this fails when minLength is empty
        System.out.println(minLength.orElseGet(()->0)); //function that returns a value when there is no value

        //or print it only if it's present
        minLength.ifPresent(
                length -> System.out.println(length)
        );

        //you can also manage the possibility of empty return inside the collection
        //then it is no longer optional because it always returns a value (orElse)
        List<String> lessColors = Arrays.asList("red", "green", "blue", "grey");
        Integer minLengthIfPresent = lessColors.stream()
                .filter(otherColor -> otherColor.startsWith("n"))
                .map(otherColor -> otherColor.length()) //--> we are now returning a list of integers and we need to change it
                .sorted()
                .findFirst()
                .orElse(0);
        System.out.println(minLengthIfPresent);
    }
}
