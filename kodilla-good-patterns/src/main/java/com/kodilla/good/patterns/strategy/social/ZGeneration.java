package com.kodilla.good.patterns.strategy.social;

public non-sealed class ZGeneration extends User {
    public ZGeneration(String name) {
        super(name);
        this.socialPublisher = new SnapchatPublisher();
    }
}
