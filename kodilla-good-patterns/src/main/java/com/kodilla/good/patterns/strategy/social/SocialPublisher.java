package com.kodilla.good.patterns.strategy.social;

public sealed interface SocialPublisher
        permits FacebookPublisher, TwitterPublisher, SnapchatPublisher {
    String share();
}
