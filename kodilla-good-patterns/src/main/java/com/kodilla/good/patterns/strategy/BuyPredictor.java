package com.kodilla.good.patterns.strategy;

public sealed interface BuyPredictor
        permits AggressivePredictor, BalancedPredictor, ConservativePredictor {
    String predictWhatToBuy();
}
