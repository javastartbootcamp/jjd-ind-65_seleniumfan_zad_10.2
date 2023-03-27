package pl.javastart.task;

public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone(new CardPhoneContract(1, .1, .2, 0.5));

        phone.printAccountState();

        phone.sendSms();
        phone.call(120);
        phone.printAccountState();

        phone.sendSms();
        phone.printAccountState();

        phone.sendSms();
        phone.printAccountState();

        System.out.println("\n");
        Phone phone2 = new Phone(new SubscriptionPhoneContract(40));

        phone2.printAccountState();

        phone2.sendSms();
        phone2.printAccountState();

        phone2.sendSms();
        phone2.printAccountState();

        phone2.sendSms();
        phone2.printAccountState();

        System.out.println("\n");
        Phone phone3 = new Phone(new MixPhoneContract(2, 2, 2, 5, .3, 2.0, 1));

        phone3.printAccountState();

        phone3.sendSms();
        phone3.call(180);
        phone3.printAccountState();

        phone3.call(60);
        phone3.sendSms();
        phone3.printAccountState();

        phone3.sendSms();
        phone3.printAccountState();
    }
}
