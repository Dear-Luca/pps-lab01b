package it.unibo.pps.e1;

public class SilverBankAccount implements BankAccount{

    private final CoreBankAccount base;
    private final int fee;

    public SilverBankAccount(CoreBankAccount base, int fee) {

        this.base = base;
        this.fee = fee;
    }

    public int getBalance() {
        return base.getBalance();
    }

    public void deposit(int amount) {
        base.deposit(amount);
    }

    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        base.withdraw(amount + fee);
    }
}
