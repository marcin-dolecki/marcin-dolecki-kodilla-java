package com.kodilla.good.patterns.strategy;

public class BalancedPredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Balanced Predictor] Buy shared units of Fund XYZ";
    }
}
