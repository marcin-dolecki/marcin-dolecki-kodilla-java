package com.kodilla.good.patterns.strategy;

public non-sealed class AggressivePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Aggressive Predictor] Buy stock of XYZ";
    }
}
