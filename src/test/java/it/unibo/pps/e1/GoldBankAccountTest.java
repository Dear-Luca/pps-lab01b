package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends AbstractBankAccountTest {
    private static final int DEPOSIT_AMOUNT = 1000;
    private BankAccount account;

    @Override
    BankAccount init() {
        this.account = new GoldBankAccount(new CoreBankAccount());
        return this.account;
    }

    @Override
    double computeBalance(double depositAmount, double withdrawAmount) {
        return depositAmount - withdrawAmount;
    }

    @Test
    public void testCanWithdrawOverdraft() {
        int withdrawAmount = 1500;
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(withdrawAmount);
        assertEquals(DEPOSIT_AMOUNT - withdrawAmount, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreOverdraft() {
        int withdrawAmount = 1501;
        this.account.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawAmount));
    }
}
