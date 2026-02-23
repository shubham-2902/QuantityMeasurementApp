package com.apps.quantitymeasurement;

public class Length {

    // Instance variables
    private double value;
    private LengthUnit unit;

    /**
     * Enum representing supported length units.
     * Conversion factors are relative to inches (base unit).
     */
    public enum LengthUnit {

        FEET(12.0),            // 1 ft = 12 in
        INCHES(1.0),           // base unit
        YARDS(36.0),           // 1 yd = 36 in
        CENTIMETERS(0.393701); // 1 cm = 0.393701 in

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // Constructor
    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    // ===== Convert this length to base unit (inches) =====
    private double convertToBaseUnit() {
        double baseValue = value * unit.getConversionFactor();
        return Math.round(baseValue * 100.0) / 100.0; // round to 2 decimals
    }

    // ===== Compare two Length objects =====
    public boolean compare(Length thatLength) {
        return Double.compare(
                this.convertToBaseUnit(),
                thatLength.convertToBaseUnit()
        ) == 0;
    }

    // ===== equals override =====
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Length other = (Length) obj;
        return compare(other);
    }

    // =========================================================
    // ===== UC5: CONVERSION FEATURE ===========================
    // =========================================================

    /**
     * Convert this Length to a target unit.
     * Returns a NEW Length object (immutability).
     */
    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        // Convert to base unit first (inches)
        double baseValue = this.value * this.unit.getConversionFactor();

        // Convert base → target
        double convertedValue =
                baseValue / targetUnit.getConversionFactor();

        // Round to 2 decimals
        convertedValue =
                Math.round(convertedValue * 100.0) / 100.0;

        return new Length(convertedValue, targetUnit);
    }

    // Optional: readable output
    @Override
    public String toString() {
        return value + " " + unit;
    }
}