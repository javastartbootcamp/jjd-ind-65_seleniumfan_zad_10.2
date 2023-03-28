package pl.javastart.task;

public abstract class PhoneContract {
    abstract boolean sendMmsIfPossible();

    abstract boolean sendSmsIfPossible();

    abstract int talkIfPossible(int callTimeSeconds);

    abstract String accountState();
}
