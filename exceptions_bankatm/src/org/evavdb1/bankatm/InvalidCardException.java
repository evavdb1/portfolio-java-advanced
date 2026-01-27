package org.evavdb1.bankatm;

public class InvalidCardException extends Exception {
    public InvalidCardException(String message) {
        super(message);
    }
}
