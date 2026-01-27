package org.evavdb1.bankatm;
import java.util.Date;
import java.util.UUID;

public class Transaction {
    private String transactionID;
    private Account account;
    private double amount;
    private String status;
    private Date timestamp;

    public Transaction(String transactionID, Account account, double amount) {
        this.transactionID = UUID.randomUUID().toString(); // generate unique transaction ID, 1. time based
        this.account = account;
        this.amount = amount;
        this.timestamp = new Date();
    }

    public String getStatus() {        return status;    }
    public String getTransactionID() {        return transactionID;    }

    public boolean process() {
        boolean success = account.debit(amount);
        status = success ? "Approved" : "Declined";
        return success;
    }

    public String generateReceipt() {
        return "TransactionID: "+transactionID+"\nStatus: "+status+"\nAmount: "+amount+"\nDate: "+timestamp;
    }
}
