package com.serenitydojo.model;

public class Feeder {
    public String feeds_DONOTUSE(String animal, boolean isPremium) {

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
    public String feeds(AnimalType animal, boolean isPremium) {

        //if instead of assigning a value to a variable we would do a return at each level,
        // break statement wouldn't be necessary, because it stops the execution
        String food;
        switch (animal) {
            case CAT:
                food = (isPremium) ? "Salmon" : "Tuna";
                break;
            case DOG:
                food = (isPremium) ? "Deluxe Dog Food" : "Dog Food";
                break;
            case HAMSTER:
                food = (isPremium) ? "Lettuce" : "Cabbage";
                break;
            default:
                food = "Don't know this aminal - Don't know the food";
        }

        return food;
    }
}
