package com.kodilla.good.patterns.ordering.notification;

public class ConsoleInformationService implements InformationService {
    @Override
    public void inform(String user, String message) {
        System.out.println("[INFO] Notifying user: " + user + " – " + message);
    }
}
