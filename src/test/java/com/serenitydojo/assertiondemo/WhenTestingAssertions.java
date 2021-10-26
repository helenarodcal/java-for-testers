package com.serenitydojo.assertiondemo;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.SoftAssertionsRule;
import org.assertj.core.data.Percentage;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WhenTestingAssertions {

    @Test
    public void should_add_two_integers_correctly() {

        int a = 1;
        int b = 2;

        int sum = a + b;
            //JUnit -- not very readable
//        Assert.assertEquals(4, sum);
            //AssertJ -- much more intuitive
        assertThat(sum).isEqualTo(3);
        assertThat(sum).isCloseTo(4, Percentage.withPercentage(50));
        assertThat(sum).isCloseTo(4, Percentage.withPercentage(10));
    }

    @Test
    public void are_these_strings_correct() {

        String color = "red";
        String otherColor = "Red";
        String oneMoreColor = "red ";

        String colors = "red, reen, blue";

        assertThat(color).isEqualToIgnoringCase(otherColor); //pass
        assertThat(color).isEqualToIgnoringWhitespace(oneMoreColor);
        assertThat(colors).startsWith(color);
        assertThat(colors).containsPattern("[g|G]reen");
        assertThat(color).isEqualTo(otherColor);
    }

    @Test
    public void are_these_collections_correct() {
        List<String> colors = Arrays.asList("red", "green", "blue");

        assertThat(colors).hasSize(3);
        assertThat(colors).contains("green");
        assertThat(colors).containsExactlyInAnyOrder("red", "blue", "green");
        assertThat(colors).doesNotContain("yellow");
    }
}
