package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest {
    private BronzeBankAccount account;
    private static final int DEPOSIT_AMOUNT = 1000;
    private static final int FEE = 1;


    @BeforeEach
    void init(){
        this.account = new BronzeBankAccount(new CoreBankAccount(), FEE);
    }

    @Test
    void testInitiallyEmpty(){
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawWithFee() {
        int withdrawAmount = 100;
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(withdrawAmount);
        assertEquals(DEPOSIT_AMOUNT - withdrawAmount - FEE, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawWithoutFee() {
        int withdrawAmount = 99;
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(withdrawAmount);
        assertEquals(DEPOSIT_AMOUNT - withdrawAmount, this.account.getBalance());
    }



    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        int withdrawAmount = 1200;
        this.account.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawAmount));
    }

}
