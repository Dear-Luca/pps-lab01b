package it.unibo.pps.e1;

public class BronzeBankAccount extends AbstractBankAccount {

    private final int fee;
    private static final int THRESHOLD = 100;

    public BronzeBankAccount(BankAccount base, int fee) {
        super(base);
        this.fee = fee;
    }

    @Override
    public void withdraw(int amount) {
        int conditionalFee = amount < THRESHOLD ? 0 : fee;
        if (this.getBalance() < amount + conditionalFee) {
            throw new IllegalStateException();
        }
        getBaseBankAccount().withdraw(amount + conditionalFee);
    }
}
