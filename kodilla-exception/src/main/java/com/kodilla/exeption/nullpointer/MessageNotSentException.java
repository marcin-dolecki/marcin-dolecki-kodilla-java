package com.kodilla.exeption.nullpointer;

public class MessageNotSentException extends Exception {
    public MessageNotSentException(final String message) {
        super(message);
    }
}
