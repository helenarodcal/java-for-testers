package com.serenitydojo;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenWorkingWithMaps {

   @Test
    public void creating_a_map() {
       Map<String, Integer> numberOfBallsByColor = new HashMap<>();

       numberOfBallsByColor.put("red", 3);
       numberOfBallsByColor.put("green", 6);
       numberOfBallsByColor.put("blue", 5);

       Integer numberOfRedBalls = numberOfBallsByColor.get("red");
       System.out.println("There are " + numberOfRedBalls + " red balls");
   }

   @Test
   public void creating_a_map_more_concisely() {
      //Java9 -- useful in testing to create test data on the fly in a concise manner
      Map<String, Integer> numberOfBallsByColor = Map.of("red", 3, "green", 6, "blue", 5);
   }

   @Test
   public void combine_maps() {
      Map<String, Integer> numberOfBallsByColor = Map.of("red", 3, "green", 6, "blue", 5);
      Map<String, Integer> moreBalls = new HashMap<>();

      moreBalls.put("yellow", 10);
      assertThat(moreBalls.size()).isEqualTo(1);

      moreBalls.putAll(numberOfBallsByColor);
      assertThat(moreBalls.size()).isEqualTo(4);
   }

   @Test
   public void retriveing_non_existing_element() {
      Map<String, Integer> numberOfBallsByColor = Map.of("red", 3, "green", 6, "blue", 5);

      System.out.println("Number of balls for white color " + numberOfBallsByColor.get("white")); //This returs null
      System.out.println("Number of balls for white color " + numberOfBallsByColor.getOrDefault("white", 0));

   }

   @Test
   public void checking_if_element_is_present() {
      Map<String, Integer> numberOfBallsByColor = Map.of("red", 3, "green", 6, "blue", 5);

      System.out.println("Are purple tennis balls present? " + numberOfBallsByColor.containsKey("purple"));
   }

   @Test
   public void updating_maps() {
      Map<String, Integer> numberOfBallsByColor = new HashMap<>();

      numberOfBallsByColor.put("red", 3);
      numberOfBallsByColor.put("green", 6);
      numberOfBallsByColor.put("blue", 5);

      //put of an existing key
      assertThat(numberOfBallsByColor.get("green")).isEqualTo(6);
      numberOfBallsByColor.put("green", 8);
      assertThat(numberOfBallsByColor.get("green")).isEqualTo(8);

      //update a value ONLY if it is already present
      numberOfBallsByColor.replace("pink", 15);
      //does not add the pink balls because they were not present befor
      assertThat(numberOfBallsByColor.getOrDefault("pink", 0)).isEqualTo(0);
   }

   @Test
   public void iterating_over_map_keys() {
      Map<String, Integer> numberOfBallsByColor = Map.of("red", 3, "green", 6, "blue", 5);

      System.out.println("Keys in map: " + numberOfBallsByColor.keySet());

      //get the key, then search for the value
      for (String key : numberOfBallsByColor.keySet()) {
         Integer numberOfTennisBalls = numberOfBallsByColor.get(key);

      System.out.println(key + " => " + numberOfTennisBalls );
      }

      //get entry maps, containing the pair key, value
      printMap(numberOfBallsByColor);
   }

   private void printMap(Map<String, Integer> numberOfBallsByColor) {
      for(Map.Entry<String, Integer> entry : numberOfBallsByColor.entrySet()) {
         System.out.println(entry.getKey() + " => " + entry.getValue());
      }
   }

   @Test
   public void remove_items_from_map() {
      //Map.of is immutable --> no updating / adding / removing allowed*
      Map<String, Integer> numberOfBallsByColor = Map.of("red", 3, "green", 6, "blue", 5);
      Map<String, Integer> modifiableMap = new HashMap<>();

      modifiableMap.putAll(numberOfBallsByColor);
      System.out.println("All elements");
      printMap(modifiableMap);

      modifiableMap.remove("green");
      System.out.println("Removed green");
      printMap(modifiableMap);

      modifiableMap.clear();
      System.out.println("Empty map");
      printMap(modifiableMap);
   }
}
