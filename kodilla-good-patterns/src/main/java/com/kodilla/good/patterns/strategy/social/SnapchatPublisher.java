package com.kodilla.good.patterns.strategy.social;

public non-sealed class SnapchatPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "[Snapchat] post on Snapchat";
    }
}
