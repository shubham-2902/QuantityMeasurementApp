package com.apps.quantitymeasurement;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {

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

    public U getUnit() {
        return unit;
    }

    // ===============================
    // EQUALITY
    // ===============================

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> other)) return false;

        if (!unit.getClass().equals(other.unit.getClass()))
            return false;

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Math.abs(base1 - base2) < 1e-6;
    }

    // ===============================
    // CONVERSION
    // ===============================

    public Quantity<U> convertTo(U targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double base = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(base);

        return new Quantity<>(converted, targetUnit);
    }

    // ===============================
    // ADDITION
    // ===============================

    public Quantity<U> add(Quantity<U> other) {

        validate(other);

        double sumBase =
                unit.convertToBaseUnit(value)
              + other.unit.convertToBaseUnit(other.value);

        double result = unit.convertFromBaseUnit(sumBase);

        return new Quantity<>(result, unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        validate(other);

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit null");

        double sumBase =
                unit.convertToBaseUnit(value)
              + other.unit.convertToBaseUnit(other.value);

        double result = targetUnit.convertFromBaseUnit(sumBase);

        return new Quantity<>(result, targetUnit);
    }

    // ===============================
    // SUBTRACTION (UC12)
    // ===============================
    

    public Quantity<U> subtract(Quantity<U> other) {

        validate(other);

        double diffBase =
                unit.convertToBaseUnit(value)
              - other.unit.convertToBaseUnit(other.value);

        double result = unit.convertFromBaseUnit(diffBase);

        return new Quantity<>(result, unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

        validate(other);

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit null");

        double diffBase =
                unit.convertToBaseUnit(value)
              - other.unit.convertToBaseUnit(other.value);

        double result = targetUnit.convertFromBaseUnit(diffBase);

        return new Quantity<>(result, targetUnit);
    }

    // ===============================
    // DIVISION (UC12)
    // ===============================

    public double divide(Quantity<U> other) {

        validate(other);

        double divisorBase = other.unit.convertToBaseUnit(other.value);

        if (Math.abs(divisorBase) < 1e-12)
            throw new ArithmeticException("Division by zero");

        double dividendBase = unit.convertToBaseUnit(value);

        return dividendBase / divisorBase;
    }

    // ===============================
    // VALIDATION
    // ===============================

    private void validate(Quantity<U> other) {

        if (other == null)
            throw new IllegalArgumentException("Quantity null");

        if (!unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Different categories");
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}