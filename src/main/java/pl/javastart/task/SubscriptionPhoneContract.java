package pl.javastart.task;

public class SubscriptionPhoneContract extends PhoneContract {
    private static final double AMOUNT_SUBSCRIPTION = 30;

    @Override
    boolean sendMmsIfPossible() {
        System.out.println("Usługa MMS w ramach abonamentu NO LIMIT");
        return true;
    }

    @Override
    boolean sendSmsIfPossible() {
        System.out.println("Usługa SMS w ramach abonamentu NO LIMIT");
        return true;
    }

    @Override
    boolean talkIfPossible() {
        System.out.println("Usługa rozmów telefonicznych w ramach abonamentu NO LIMIT");
        return true;
    }

    @Override
    void accountState() {
        System.out.println("Rachunek wynosi: " + AMOUNT_SUBSCRIPTION);
    }
}
