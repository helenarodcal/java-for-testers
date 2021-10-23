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
            return "Meat";
        } /*else{
            return "Cabbage";
        }*/
        return "Cabbage";
    }
}
