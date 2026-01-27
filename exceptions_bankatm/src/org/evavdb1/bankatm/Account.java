package org.evavdb1.bankatm;

public class Account {
    private String accountNumber;
    private double balance;
    private double dailyLimit;

    public Account(String accountNumber, double balance, double dailyLimit) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.dailyLimit = dailyLimit;
    }

    public double getBalance() {        return balance;    }
    public String getAccountNumber() {        return accountNumber;    }

    protected boolean debit(double amount) {
        if (hasSufficientFunds(amount) && withinDailyLimit(amount)) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean hasSufficientFunds(double amount){
        return balance >= amount;
    }

    public boolean withinDailyLimit(double amount) {
        return amount <= dailyLimit;
    }
}
