package org.evavdb1.bankatm;
import java.util.ArrayList;
import java.util.List;

public class ATM {
    private String atmID;
    private double cashAvailable;
    private List<String> transactionLog = new ArrayList<>();
    private BankSystem bankSystem = new BankSystem();
    private static final int MAX_PIN_ATTEMPTS = 3;

    public ATM(String atmID, double cashAvailable) {
        this.atmID = atmID;
        this.cashAvailable = cashAvailable;
    }

    public void ATMUse(BankCustomer customer, String pin, double amount) throws InvalidCardException,InvalidPinException,
            PinAttemptExceededException, InsufficientFundsException, DailyLimitExceededException, CashUnavailableException {

        Card card = customer.getCard();
            if (!insertCard(card)) {
                throw new InvalidCardException("Invalid card");
            }
            if (!validatePin(card, pin)) {
                throw new InvalidPinException("Pin incorrect");
            }

        Account account = customer.getAccount("debit");
            if (account == null) {
                throw new RuntimeException("No account exists");
            }
            if (!account.hasSufficientFunds(amount)) {
                throw new InsufficientFundsException("Insufficient funds");
            }
            if (!account.withinDailyLimit(amount)) {
                throw new DailyLimitExceededException("Daily limit exceeded");
            }
            if (!checkCashAvailability(amount)) {
                throw new CashUnavailableException("Not enough cash in ATM");
            }

        Transaction transaction = new Transaction("TaXion "+System.currentTimeMillis(), account, amount);
            if (bankSystem.verifyTransAction(transaction)){
                dispenseCash(amount);
                printReceipt(transaction);
                logTransaction("Withdrawel of €"+amount);
            } else {
                logTransaction("Transaction declined");
            }

        ejectCard();
    }

    public boolean insertCard(Card card) {
        return card.validate();
    }

    public boolean validatePin(Card card, String pin) throws PinAttemptExceededException {
        if ("1234".equals(pin)) {
            card.resetAttempts();
            return true;
        } else {
            card.incrementAttempts();
            if (card.getAttempts() >= MAX_PIN_ATTEMPTS) {
                logTransaction("All attempts used, Card retained");
                throw new PinAttemptExceededException("All PIN attempts incorrect");
            }
            return false;
        }
    }

    public boolean checkCashAvailability(double amount) {
        return cashAvailable >= amount;
    }

    public void dispenseCash(double amount) {
        cashAvailable -= amount;
        System.out.println("€"+amount+" dispensed");
    }

    public void printReceipt(Transaction transaction) {
        System.out.println("receipt "+transaction.generateReceipt());
    }

    public void logTransaction(String message) {
        transactionLog.add(message);
        System.out.println("ATM log: "+message);
    }

    public void ejectCard() {
        System.out.println("card ejected");
    }
}
