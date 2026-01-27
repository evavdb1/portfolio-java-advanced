package org.evavdb1.bankatm;

import java.util.Arrays;

public class ATMMain {
    public static void main(String[] args) {

        Card card01 = new Card("987654321", true);
        Account account01 = new Account("BE00000000001212", 666.0,1000);
        BankCustomer customer01 = new BankCustomer("Monay", Arrays.asList(account01), card01);
        ATM atm99 = new ATM("Rouppeplein", 1000.0);

        double withdrawal01 = 100.0;
        double withdrawal02 = 400.0;
        double withdrawal03 = 600.0;
        double withdrawal04 = 700.0;

        String pin = "1234";

        try {
            System.out.println();
            atm99.ATMUse(customer01,pin,withdrawal01);
        } catch (InvalidCardException | InvalidPinException | PinAttemptExceededException | InsufficientFundsException
                | DailyLimitExceededException | CashUnavailableException e) {
            System.out.println("Something went wrong..."+e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: "+e.getMessage());
        }

        try {
            System.out.println();
            atm99.ATMUse(customer01,pin,withdrawal02);
        } catch (InvalidCardException | InvalidPinException | PinAttemptExceededException | InsufficientFundsException
                 | DailyLimitExceededException | CashUnavailableException e) {
            System.out.println("Something went wrong..."+e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: "+e.getMessage());
        }

        try {
            System.out.println();
            atm99.ATMUse(customer01,pin,withdrawal03);
        } catch (InvalidCardException | InvalidPinException | PinAttemptExceededException | InsufficientFundsException
                 | DailyLimitExceededException | CashUnavailableException e) {
            System.out.println("Something went wrong..."+e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: "+e.getMessage());
        }

        try {
            System.out.println();
            atm99.ATMUse(customer01,pin,withdrawal04);
        } catch (InvalidCardException | InvalidPinException | PinAttemptExceededException | InsufficientFundsException
                 | DailyLimitExceededException | CashUnavailableException e) {
            System.out.println("Something went wrong..."+e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: "+e.getMessage());
        }
    }
}
