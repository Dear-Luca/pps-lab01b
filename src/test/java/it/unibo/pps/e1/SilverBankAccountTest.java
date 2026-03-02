package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest {

    private SilverBankAccount account;
    private static final int FEE = 1;
    private static final int DEPOSIT_AMOUNT = 1000;

    @BeforeEach
    void init(){
        this.account = new SilverBankAccount(new CoreBankAccount(), FEE);
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
    public void testCanWithdraw() {
        int withdrawAmount = 200;
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(withdrawAmount);
        assertEquals(DEPOSIT_AMOUNT - withdrawAmount - FEE, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        int withdrawAmount = 1200;
        this.account.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawAmount));
    }

}
