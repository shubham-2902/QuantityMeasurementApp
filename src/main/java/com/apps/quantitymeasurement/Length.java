package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // Convert to another unit
    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double base = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(base);

        return new Length(converted, targetUnit);
    }

    // Add → result in same unit as THIS object (UC6)
    public Length add(Length other) {

        if (other == null)
            throw new IllegalArgumentException("Other length cannot be null");

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double sumBase = base1 + base2;
        double result = unit.convertFromBaseUnit(sumBase);

        return new Length(result, unit);
    }

    // Add → result in specified target unit (UC7)
    public Length add(Length other, LengthUnit targetUnit) {

        if (other == null || targetUnit == null)
            throw new IllegalArgumentException("Invalid arguments");

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double sumBase = base1 + base2;
        double result = targetUnit.convertFromBaseUnit(sumBase);

        return new Length(result, targetUnit);
    }

    private boolean compare(Length other) {

        double base1 = unit.convertToBaseUnit(value);
        
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Math.abs(base1 - base2) < 1e-4;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof Length)) return false;

        Length other = (Length) obj;
        return compare(other);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}