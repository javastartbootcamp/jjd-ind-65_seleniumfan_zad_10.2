package pl.javastart.task;

public class Phone {
    private int sms;
    private int mms;
    private int talk;
    private PhoneContract phoneContract;

    public Phone(PhoneContract phoneContract) {
        this.phoneContract = phoneContract;
    }

    public void sendSms() {
        if (phoneContract.sendSmsIfPossible()) {
            sms++;
            System.out.println("SMS wysłany");
        } else {
            System.out.println("Nie udało się wysłać SMSa\n");
        }
    }

    public void call(int seconds) {
        int secondActuallyTalked = phoneContract.talkIfPossible(seconds);
        if (secondActuallyTalked <= 0) {
            System.out.println("Nie masz wystarczających środków na koncie żeby rozmawiać");
        } else {
            System.out.println("Rozmowa trwała " + secondActuallyTalked + " sekund");
            talk += secondActuallyTalked;
        }
    }

    public boolean sendMms() {
        if (phoneContract.sendMmsIfPossible()) {
            mms++;
            System.out.println("MMS wysłany");
            return true;
        }
        System.out.println("Nie udało się wysłać MMSa");
        return false;
    }

    public void printAccountState() {
        System.out.println("=== STAN KONTA ===");
        System.out.println("Wysłanych SMSów: " + sms);
        System.out.println("Wysłanych MMSów: " + mms);
        System.out.println("Liczba sekund rozmów: " + talk);
        System.out.println(phoneContract.accountState());
        System.out.println();
    }
}
