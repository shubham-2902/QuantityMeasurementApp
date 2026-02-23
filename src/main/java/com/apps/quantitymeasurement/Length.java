package com.apps.quantitymeasurement;

public class Length {

    // Instance variables
    private double value;
    private LengthUnit unit;

    // ===== ENUM WITH ALL UNITS =====
    public enum LengthUnit {

        FEET(12.0),        // 1 ft = 12 in
        INCHES(1.0),       // base unit
        YARDS(36.0),       // 1 yd = 36 in
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

    // Convert to base unit 
    private double convertToBaseUnit() {

        double baseValue = value * unit.getConversionFactor();

        // Round to 2 decimal places
        return Math.round(baseValue * 100.0) / 100.0;
    }

    // Compare method
    public boolean compare(Length thatLength) {
        return Double.compare(
                this.convertToBaseUnit(),
                thatLength.convertToBaseUnit()
        ) == 0;
    }

    // equals override
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Length other = (Length) obj;
        return compare(other);
    }
}