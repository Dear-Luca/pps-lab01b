package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount {
    private final BankAccount base;
    private static final int OVERDRAFT = 500;

    public GoldBankAccount(BankAccount base) {
        this.base = base;
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        this.base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if (amount - this.getBalance() > OVERDRAFT) {
            throw new IllegalStateException();
        }
        this.base.withdraw(amount);
    }
}
