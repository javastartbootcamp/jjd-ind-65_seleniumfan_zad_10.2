package pl.javastart.task;

public class MixPhoneContract extends PhoneContract {
    private static int freeSms = 2;
    private static int freeMms = 2;
    private static int extraMinutes = 2;
    private double smsCost;
    private double mmsCost;
    private double accountState;
    private double minuteCost;

    public MixPhoneContract(double smsCost, double mmsCost, double accountState, double minuteCost) {
        this.smsCost = smsCost;
        this.mmsCost = mmsCost;
        this.accountState = accountState;
        this.minuteCost = minuteCost;
    }

    @Override
    boolean sendMmsIfPossible() {
        if (freeMms > 0) {
            freeMms--;
            return true;
        }

        if (accountState >= mmsCost) {
            accountState = accountState - mmsCost;
            return true;
        }
        return false;
    }

    @Override
    boolean sendSmsIfPossible() {
        if (freeSms > 0) {
            freeSms--;
            return true;
        }

        if (accountState >= smsCost) {
            accountState = accountState - smsCost;
            return true;
        }
        return false;
    }

    @Override
    boolean talkIfPossible() {
        if (extraMinutes > 0) {
            return true;
        }

        if (accountState >= minuteCost / 60) {
            return true;
        }
        return false;
    }

    @Override
    void accountState() {
        System.out.printf("Ilość darmowych SMSów: %d, ilość darmowych MMSów: %d," +
                " ilość darmowych minut: %d, stan konta: %.2f", freeSms, freeMms, extraMinutes, accountState);
    }
}
