package Oberser;

import interfaces.IObserver;

public class ConsoleNotifier implements IObserver {

    @Override
    public void update(String msg) {
        System.out.println("Recieved in notifier: "+ msg);
    }
}
