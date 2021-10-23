package com.serenitydojo.model;

public class Feeder {
    public String feeds(String animal, boolean isPremium) {

        if(animal.equals("Cat")){
//            if(isPremium) {
//                return "Salmon";
//            } else {
//                return "Tuna";
//            }
        //ternary expression
            return(isPremium) ? "Salmon" : "Tuna";

        }else if (animal.equals("Dog")){
            return (isPremium) ? "Deluxe Dog Food" : "Dog Food";
        } /*else{
            return "Cabbage";
        }*/
        return (isPremium) ? "Lettuce" : "Cabbage";


    }
}
