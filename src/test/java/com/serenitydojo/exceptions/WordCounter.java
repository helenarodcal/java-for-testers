package com.serenitydojo.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class WordCounter {

    public int numberOfWordsIn(String value) {

        //added condition when test failed
        if(value == null || value.isEmpty()){
            return 0;
        }

        return value.split("\\W").length;
    }

//    public int numberOfWordsInFile(String fileName) throws IOException {
//        String fileContents = Files.readString(Paths.get(fileName));
//        return numberOfWordsIn(fileContents);
//    }

//    public int numberOfWordsInFile(String fileName) {
//        try {
//            String fileContents = Files.readString(Paths.get(fileName));
//            return numberOfWordsIn(fileContents);
//        }catch (NoSuchFileException noSuchFile) {
//            return 0;
//        }catch (IOException otherException) {
//            return -1;
//        } finally {
//            //this is always executed, no matter the exceptions
//            //normally used to close resources
//            System.out.println("FILE PROCESSED FOR " + fileName);
//        }
//    }

    public int numberOfWordsInFile(String fileName) throws IOException {
        try {
            String fileContents = Files.readString(Paths.get(fileName));
            int wordCount = numberOfWordsIn(fileContents);
            if (wordCount == 0) {
                throw new FileHasNoWordsException("No words found in the file " + fileName);
            }
            return wordCount;
        } catch (NoSuchFileException noSuchFile) {

            throw new FileHasNoWordsException("No words found in the non-existent file " + fileName);
        } finally {
            //this is always executed, no matter the exceptions
            //normally used to close resources
            System.out.println("FILE PROCESSED FOR " + fileName);
        }
    }
}
