package it.unibo.pps.e1;

public class GoldBankAccount extends AbstractBankAccount {

    private static final int OVERDRAFT = 500;

    public GoldBankAccount(BankAccount base) {
        super(base);
    }

    @Override
    public void withdraw(int amount) {
        if (amount - this.getBalance() > OVERDRAFT) {
            throw new IllegalStateException();
        }
        getBaseBankAccount().withdraw(amount);
    }
}
