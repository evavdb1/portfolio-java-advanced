package org.evavdb1.bankatm;

public class CashUnavailableException extends Exception {
    public CashUnavailableException(String message){
        super(message);
    }
}
