package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends AbstractBankAccountTest {
    private BankAccount account;
    private static final int DEPOSIT_AMOUNT = 1000;
    private static final int FEE = 1;
    private static final int THRESHOLD = 100;


    @Override
    BankAccount init() {
        this.account = new BronzeBankAccount(new CoreBankAccount(), FEE);
        return this.account;
    }

    @Override
    double computeBalance(double depositAmount, double withdrawAmount) {
        return depositAmount - withdrawAmount - (withdrawAmount < THRESHOLD ? 0 : FEE);
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable() {
        int withdrawAmount = 1200;
        this.account.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawAmount));
    }
}
