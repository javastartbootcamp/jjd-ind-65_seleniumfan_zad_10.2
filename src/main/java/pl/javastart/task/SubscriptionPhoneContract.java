package pl.javastart.task;

public class SubscriptionPhoneContract extends PhoneContract {
    private double amountSubscription;

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
    int talkIfPossible(int callTimeSeconds) {
        return callTimeSeconds;
    }

    @Override
    String accountState() {
        return "Rachunek wynosi: " + amountSubscription;
    }
}
