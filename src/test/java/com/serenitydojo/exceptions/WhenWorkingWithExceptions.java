package com.serenitydojo.exceptions;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenWorkingWithExceptions {

    WordCounter wordCounter = new WordCounter();

    @Test
    public void should_count_the_words_in_a_string() {

        int numberOfWords = wordCounter.numberOfWordsIn("some string");

        assertThat(numberOfWords).isEqualTo(2);
    }

    //checking the null value, now that we know it failes with an empty string
    @Test
    public void should_return_zero_for_a_null_string() {

        assertThat(wordCounter.numberOfWordsIn(null)).isEqualTo(0);
    }

    @Test
    public void should_count_words_in_a_file() throws Exception{

        int numberOfWords = wordCounter.numberOfWordsInFile("src/main/resources/hello.txt");

        assertThat(numberOfWords).isEqualTo(2);
    }

    @Test(expected = FileHasNoWordsException.class)
    public void should_report_an_error_if_the_file_does_not_exist() throws Exception{

       int numberOfWords = wordCounter.numberOfWordsInFile("file-that-does-not-exist.txt");
       assertThat(numberOfWords).isEqualTo(0);
    }

    @Test(expected = FileHasNoWordsException.class)
    public void should_throw_meaningful_exception_if_there_are_no_words_in_the_file() throws Exception {
       assertThat(wordCounter.numberOfWordsInFile("src/main/resources/no_words.txt")).isEqualTo(0);

    }
}
