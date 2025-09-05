package com.kodilla.good.patterns2.observer.forum;

import java.util.ArrayList;
import java.util.List;

public class ForumTopic implements Observable {
    private final List<Observer> observers;
    private final List<String> messages;
    private final String name;

    public ForumTopic(String name) {
        observers = new ArrayList<>();
        messages = new ArrayList<>();
        this.name = name;
    }

    public void addPost(String post) {
        messages.add(post);
        notifyObservers(post);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers(String post) {
        for (Observer observer : observers) {
            observer.update(this, post);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public List<String> getMessages() {
        return messages;
    }

    public String getName() {
        return name;
    }
}
