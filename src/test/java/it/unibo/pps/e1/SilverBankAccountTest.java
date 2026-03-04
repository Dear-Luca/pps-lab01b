package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends AbstractBankAccountTest {
    private static final int FEE = 1;
    private BankAccount account;
    private static final int DEPOSIT_AMOUNT = 1000;

    @Override
    BankAccount init() {
        this.account = new SilverBankAccount(new CoreBankAccount(), FEE);
        return this.account;
    }

    @Override
    double computeBalance(double depositAmount, double withdrawAmount) {
        return depositAmount - withdrawAmount - FEE;
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable() {
        int withdrawAmount = 1200;
        this.account.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawAmount));
    }
}
