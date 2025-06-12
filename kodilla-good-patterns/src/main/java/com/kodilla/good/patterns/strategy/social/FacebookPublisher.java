package com.kodilla.good.patterns.strategy.social;

public non-sealed class FacebookPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "[Facebook] post on facebook";
    }
}
