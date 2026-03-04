package it.unibo.pps.e1;

public class BronzeBankAccount implements BankAccount {
    private final BankAccount base;
    private final int fee;
    private static final int THRESHOLD = 100;

    public BronzeBankAccount(BankAccount base, int fee) {
        this.base = base;
        this.fee = fee;
    }

    @Override
    public int getBalance() {
        return this.base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        this.base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        int conditionalFee = amount < THRESHOLD ? 0 : fee;
        if (this.getBalance() < amount + conditionalFee) {
            throw new IllegalStateException();
        }
        base.withdraw(amount + conditionalFee);
    }
}
