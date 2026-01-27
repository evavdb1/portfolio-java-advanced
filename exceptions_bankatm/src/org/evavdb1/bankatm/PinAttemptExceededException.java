package org.evavdb1.bankatm;

public class PinAttemptExceededException extends Exception {
    public PinAttemptExceededException(String message) {
        super(message);
    }
}
