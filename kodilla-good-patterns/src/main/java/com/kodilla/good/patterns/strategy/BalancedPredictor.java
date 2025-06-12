package com.kodilla.good.patterns.strategy;

public non-sealed class BalancedPredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Balanced Predictor] Buy shared units of Fund XYZ";
    }
}
