package pl.javastart.task;

public class SubscriptionPhoneContract extends PhoneContract {
    private double amountSubscription = 30;

    public SubscriptionPhoneContract(double amountSubscription) {
        this.amountSubscription = amountSubscription;
    }

    @Override
    boolean sendMmsIfPossible() {
        return true;
    }

    @Override
    boolean sendSmsIfPossible() {
        return true;
    }

    @Override
    int talkIfPossible(int secondsExpected) {
        return secondsExpected;
    }

    @Override
    void accountState() {
        System.out.println("Rachunek wynosi: " + amountSubscription);
    }
}
