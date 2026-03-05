package it.unibo.pps.e1;

public abstract class AbstractBankAccount implements BankAccount {
    private final BankAccount base;

    protected AbstractBankAccount(BankAccount base) {
        this.base = base;
    }

    protected BankAccount getBaseBankAccount() {
        return this.base;
    }

    public int getBalance() {
        return base.getBalance();
    }

    public void deposit(int amount) {
        base.deposit(amount);
    }

    public abstract void withdraw(int amount);
}
