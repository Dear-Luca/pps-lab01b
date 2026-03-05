package it.unibo.pps.e1;

public class SilverBankAccount extends AbstractBankAccount {

    private final int fee;

    public SilverBankAccount(BankAccount base, int fee) {
        super(base);
        this.fee = fee;
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < (amount + fee)) {
            throw new IllegalStateException();
        }
        getBaseBankAccount().withdraw(amount + fee);
    }
}
