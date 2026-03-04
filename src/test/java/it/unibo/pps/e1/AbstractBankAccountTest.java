package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class AbstractBankAccountTest {
    private BankAccount account;
    private static final int DEPOSIT_AMOUNT = 1000;

    abstract BankAccount init();

    @BeforeEach
    public void beforeEach() {
        account = init();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, this.account.getBalance());
    }

    @Test
    void testCanWithdraw(){
        final int withdrawAmount = 200;
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(withdrawAmount);
        assertEquals(computeBalance(DEPOSIT_AMOUNT, withdrawAmount), this.account.getBalance());
    }

    abstract double computeBalance(double depositAmount, double withdrawAmount);
}
