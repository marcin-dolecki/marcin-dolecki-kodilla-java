package com.kodilla.good.patterns.strategy.social;

public non-sealed class TwitterPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "[Twitter] post on Twitter";
    }
}
