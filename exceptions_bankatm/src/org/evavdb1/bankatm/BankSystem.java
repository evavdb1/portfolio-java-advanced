package org.evavdb1.bankatm;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankSystem {
    public static final Logger logger = Logger.getLogger(BankSystem.class.getName());

    public boolean verifyTransAction(Transaction transaction) {
        return transaction.process();
    }

    public void logEvent(String message) {
        logger.log(Level.INFO, "Bank Log ", message);
    }
}
