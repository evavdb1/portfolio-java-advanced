package org.evavdb1.bankatm;

public class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}
