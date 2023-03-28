package pl.javastart.task;

public class MixPhoneContract extends CardPhoneContract {
    private int freeSms;
    private int freeMms;
    private double extraMinutes;

    public MixPhoneContract(int freeSms, int freeMms, double extraMinutes, double accountState, double smsCost, double mmsCost, double minuteCost) {
        super(accountState, smsCost, mmsCost, minuteCost);
        this.freeSms = freeSms;
        this.freeMms = freeMms;
        this.extraMinutes = extraMinutes;
    }

    @Override
    public boolean sendMmsIfPossible() {
        if (freeMms > 0) {
            freeMms--;
            return true;
        }

        return super.sendMmsIfPossible();
    }

    @Override
    public boolean sendSmsIfPossible() {
        if (freeSms > 0) {
            freeSms--;
            return true;
        }

        return super.sendSmsIfPossible();
    }

    @Override
    int talkIfPossible(int callTimeSeconds) {
        double extraSeconds = extraMinutes * 60;
        if (extraSeconds - callTimeSeconds >= 0) {
            extraMinutes -= (callTimeSeconds / 60.0);
            return callTimeSeconds;
        } else {
            int overSeconds = (int) (callTimeSeconds - extraSeconds);
            extraMinutes = 0;
            return callTimeSeconds - overSeconds + super.talkIfPossible(overSeconds);
        }
    }

    @Override
    String accountState() {
        return String.format("Ilość darmowych SMSów: %d, ilość darmowych MMSów: %d," +
                " ilość darmowych minut: %.2f, stan konta: %.2f", freeSms, freeMms, extraMinutes, getAccountState());
    }
}
