package com.apps.quantitymeasurement;

public class Length {

    // Instance variables
    private double value;
    private LengthUnit unit;

    // ---------------- ENUM ----------------
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double factor) {
            this.conversionFactor = factor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // ---------------- CONSTRUCTOR ----------------
    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    // ---------------- BASE CONVERSION ----------------
    private double convertToBaseUnit() {

        double inches = value * unit.getConversionFactor();

        // ⭐ Round to 2 decimal places
        return Math.round(inches * 100.0) / 100.0;
    }

    // ---------------- EQUALITY ----------------
    private boolean compare(Length that) {
        return Double.compare(
                this.convertToBaseUnit(),
                that.convertToBaseUnit()) == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length that = (Length) o;
        return compare(that);
    }

    // ---------------- CONVERSION ----------------
    public Length convertTo(LengthUnit targetUnit) {

        double baseValue = convertToBaseUnit();

        double convertedValue =
                baseValue / targetUnit.getConversionFactor();

        return new Length(convertedValue, targetUnit);
    }

    // UC-6 methods for Addition
    public Length add(Length thatLength) {

        if (thatLength == null) {
            throw new IllegalArgumentException(
                    "Length to add cannot be null");
        }

        // Convert both to base unit (inches)
        double sumInBase =
                this.convertToBaseUnit()
              + thatLength.convertToBaseUnit();

        // Convert sum back to THIS unit
        double resultValue =
                sumInBase / this.unit.getConversionFactor();

        return new Length(resultValue, this.unit);
    }

    // ---------------- TO STRING ----------------
    @Override
    public String toString() {
        return value + " " + unit;
    }
}