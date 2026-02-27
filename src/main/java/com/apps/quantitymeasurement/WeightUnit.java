package com.apps.quantitymeasurement;

public enum WeightUnit {

    MILLIGRAM(0.001),
    GRAM(1.0),
    KILOGRAM(1000.0),
    POUND(453.592);

    private final double conversionFactor; // to base unit (grams)

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    // Convert value in this unit → grams (base unit)
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    // Convert grams → this unit
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }
}