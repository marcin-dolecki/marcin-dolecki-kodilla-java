package com.kodilla.good.patterns2.observer.forum;

public interface Observable {
    void registerObserver(Observer observer);
    void notifyObservers(String post);
    void removeObserver(Observer observer);
}
