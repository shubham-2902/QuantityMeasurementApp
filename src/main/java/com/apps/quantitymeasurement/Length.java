package com.apps.quantitymeasurement;

public class Length {

    private double value;
    private LengthUnit unit;
    // ENUMS 
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

    
    // BASE UNIT CONVERSION (INCHES)
   
    private double convertToBaseUnit() {

        double inches = value * unit.getConversionFactor();

        // Round to 2 decimal places
        return Math.round(inches * 100.0) / 100.0;
    }

    
    // EQUALITY
    
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

   
    // CONVERSION
    
    public Length convertTo(LengthUnit targetUnit) {

        double baseValue = convertToBaseUnit();

        double convertedValue =
                baseValue / targetUnit.getConversionFactor();

        return new Length(convertedValue, targetUnit);
    }
    
    // UC6 — ADDITION (Result in FIRST operand unit)
    
    public Length add(Length thatLength) {

        if (thatLength == null)
            throw new IllegalArgumentException("Length cannot be null");

        double sumInBase =
                this.convertToBaseUnit()
              + thatLength.convertToBaseUnit();

        double resultValue =
                sumInBase / this.unit.getConversionFactor();

        return new Length(resultValue, this.unit);
    }
    
              //UC7 — ADDITION WITH TARGET UNIT 
    public Length add(Length thatLength, LengthUnit targetUnit) {

        if (thatLength == null || targetUnit == null)
            throw new IllegalArgumentException("Invalid input");

        double sumInBase =
                this.convertToBaseUnit()
              + thatLength.convertToBaseUnit();

        double resultValue =
                sumInBase / targetUnit.getConversionFactor();

        return new Length(resultValue, targetUnit);
    }

    // ---------------- TO STRING ----------------
    @Override
    public String toString() {
        return value + " " + unit;
    }
}