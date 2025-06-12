package com.kodilla.good.patterns.strategy.social;

public non-sealed class YGeneration extends User {
    public YGeneration(String name) {
        super(name);
        this.socialPublisher = new TwitterPublisher();
    }
}
