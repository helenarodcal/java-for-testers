package com.serenitydojo.exceptions;

public class FileHasNoWordsException extends RuntimeException{

    public FileHasNoWordsException(String message) {
        super(message);
    }

    public FileHasNoWordsException(String message, Throwable cause) {
        super(message, cause);
    }
}
