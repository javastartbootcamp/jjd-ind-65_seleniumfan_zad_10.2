package pl.javastart.task;

public class CardPhoneContract extends PhoneContract {
    private double accountState;
    private double smsCost;
    private double mmsCost;
    private double minuteCost;

    public CardPhoneContract(double accountState, double smsCost, double mmsCost, double minuteCost) {
        this.accountState = accountState;
        this.smsCost = smsCost;
        this.mmsCost = mmsCost;
        this.minuteCost = minuteCost;
    }

    public double getAccountState() {
        return accountState;
    }

    public void setAccountState(double accountState) {
        this.accountState = accountState;
    }

    public double getSmsCost() {
        return smsCost;
    }

    public void setSmsCost(double smsCost) {
        this.smsCost = smsCost;
    }

    public double getMmsCost() {
        return mmsCost;
    }

    public void setMmsCost(double mmsCost) {
        this.mmsCost = mmsCost;
    }

    public double getMinuteCost() {
        return minuteCost;
    }

    public void setMinuteCost(double minuteCost) {
        this.minuteCost = minuteCost;
    }

    @Override
    public boolean sendMmsIfPossible() {
        if (accountState >= mmsCost) {
            accountState = accountState - mmsCost;
            return true;
        }
        return false;
    }

    @Override
    public boolean sendSmsIfPossible() {
        if (accountState >= smsCost) {
            accountState = accountState - smsCost;
            return true;
        }
        return false;
    }

    @Override
    boolean talkIfPossible() {
        return !(accountState - minuteCost / 60 <= 0);
    }

    @Override
    void accountState() {
        System.out.println("Na koncie zostało " + accountState + " zł");
    }
}
