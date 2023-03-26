package pl.javastart.task;

public class Phone {
    private int sms;
    private int mms;
    private int talk;
    PhoneContract phoneContract;

    public Phone(PhoneContract phoneContract) {
        this.phoneContract = phoneContract;
    }

    public boolean sendSms() {
        if (phoneContract.sendSmsIfPossible()) {
            sms++;
            System.out.println("SMS wysłany");
            return true;
        }
        System.out.println("Nie udało się wysłać SMSa\n");
        return false;
    }

    public void call(int seconds) {
        if (!phoneContract.talkIfPossible()) {
            System.out.println("Nie masz wystarczających środków na koncie żeby rozmawiać");
        }
        talk += seconds;
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
        System.out.println("Liczba sekund rozmowy: " + talk);
        phoneContract.accountState();
        System.out.println();
    }

}
