package com.kodilla.good.patterns.strategy;

public non-sealed class ConservativePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Conservative Predictor] Buy debentures of XYZ";
    }
}
