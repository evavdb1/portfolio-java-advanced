package org.evavdb1.bankatm;
import java.util.List;

public class BankCustomer {
    private String name;
    private List<Account> accounts;
    private Card card;

    public BankCustomer(String name, List<Account> accounts, Card card) {
        this.name = name;
        this.accounts = accounts;
        this.card = card;
    }

    public Card getCard() {        return card;    }
    public String getName() {        return name;    }

    public Account getAccount(String type) {
        return accounts.isEmpty() ? null : accounts.get(0); // first account, at index 0
    }
}
