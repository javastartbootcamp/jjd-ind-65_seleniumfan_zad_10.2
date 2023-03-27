package pl.javastart.task;

public class MixPhoneContract extends CardPhoneContract {
    private int freeSms = 2;
    private int freeMms = 2;
    private double extraMinutes = 2;

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
    int talkIfPossible(int secondsExpected) {
        double extraSeconds = extraMinutes * 60;
        if (extraSeconds - secondsExpected >= 0) {
            extraMinutes -= (secondsExpected / 60.0);
            return secondsExpected;
        } else {
            int overSeconds = (int) (secondsExpected - extraSeconds);
            extraMinutes = 0;
            return secondsExpected - overSeconds + super.talkIfPossible(overSeconds);
        }
    }

    @Override
    void accountState() {
        System.out.printf("Ilość darmowych SMSów: %d, ilość darmowych MMSów: %d," +
                " ilość darmowych minut: %.2f, stan konta: %.2f", freeSms, freeMms, extraMinutes, getAccountState());
    }
}
