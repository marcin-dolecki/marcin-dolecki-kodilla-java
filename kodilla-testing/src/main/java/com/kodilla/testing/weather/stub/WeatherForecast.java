package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public Double getAverageTemperature() {
        double sumOfTemperatures = 0.0;

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            sumOfTemperatures += temperature.getValue();
        }
        return sumOfTemperatures / temperatures.getTemperatures().size();
    }

    public Double getMedianTemperature() {
        List<Double> temperatureValues = new ArrayList<>(temperatures.getTemperatures().values());
        Collections.sort(temperatureValues);
        int size = temperatureValues.size();

        if (size % 2 == 0) {
            return (temperatureValues.get((size / 2) - 1) + temperatureValues.get((size / 2))) / 2.0;
        } else {
            return temperatureValues.get(size / 2);
        }
    }
}
