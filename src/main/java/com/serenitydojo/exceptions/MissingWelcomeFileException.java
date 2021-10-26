package com.serenitydojo.exceptions;

public class MissingWelcomeFileException extends RuntimeException {

    public MissingWelcomeFileException(String message) {
        super(message);
    }
}
