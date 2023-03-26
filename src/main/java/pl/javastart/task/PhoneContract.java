package pl.javastart.task;

public abstract class PhoneContract {
    abstract boolean sendMmsIfPossible();

    abstract boolean sendSmsIfPossible();

    abstract boolean talkIfPossible();

    abstract void accountState();
}
