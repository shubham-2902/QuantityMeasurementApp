package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // ============================================
    // UC10 — Generic Demonstration Methods
    // ============================================

    // Equality
    public static <U extends IMeasurable> boolean
    demonstrateEquality(Quantity<U> q1, Quantity<U> q2) {

        if (q1 == null || q2 == null)
            throw new IllegalArgumentException("Quantity cannot be null");

        return q1.equals(q2);
    }

    // Conversion
    public static <U extends IMeasurable> Quantity<U>
    demonstrateConversion(Quantity<U> quantity, U targetUnit) {

        if (quantity == null || targetUnit == null)
            throw new IllegalArgumentException("Invalid arguments");

        return quantity.convertTo(targetUnit);
    }

    // Addition → implicit target (first unit)
    public static <U extends IMeasurable> Quantity<U>
    demonstrateAddition(Quantity<U> q1, Quantity<U> q2) {

        if (q1 == null || q2 == null)
            throw new IllegalArgumentException("Invalid arguments");

        return q1.add(q2);
    }

    // Addition → explicit target unit
    public static <U extends IMeasurable> Quantity<U>
    demonstrateAddition(Quantity<U> q1,
                        Quantity<U> q2,
                        U targetUnit) {

        if (q1 == null || q2 == null || targetUnit == null)
            throw new IllegalArgumentException("Invalid arguments");

        return q1.add(q2, targetUnit);
    }

    // ============================================
    // UC12 — NEW METHODS
    // ============================================

    // Subtraction → implicit unit
    public static <U extends IMeasurable> Quantity<U>
    demonstrateSubtraction(Quantity<U> q1, Quantity<U> q2) {

        if (q1 == null || q2 == null)
            throw new IllegalArgumentException("Invalid arguments");

        return q1.subtract(q2);
    }

    // Subtraction → explicit target unit
    public static <U extends IMeasurable> Quantity<U>
    demonstrateSubtraction(Quantity<U> q1,
                           Quantity<U> q2,
                           U targetUnit) {

        if (q1 == null || q2 == null || targetUnit == null)
            throw new IllegalArgumentException("Invalid arguments");

        return q1.subtract(q2, targetUnit);
    }

    // Division → returns scalar
    public static <U extends IMeasurable> double
    demonstrateDivision(Quantity<U> q1, Quantity<U> q2) {

        if (q1 == null || q2 == null)
            throw new IllegalArgumentException("Invalid arguments");

        return q1.divide(q2);
    }

    // ============================================
    // MAIN METHOD (Demo Only)
    // ============================================

    public static void main(String[] args) {

        // ---------- LENGTH ----------
        Quantity<LengthUnit> length1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> length2 =
                new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("Length Equal: "
                + demonstrateEquality(length1, length2));

        System.out.println("Length in inches: "
                + demonstrateConversion(length1, LengthUnit.INCHES));

        System.out.println("Length Sum (feet): "
                + demonstrateAddition(length1, length2));

        System.out.println("Length Difference (feet): "
                + demonstrateSubtraction(length1, length2));

        System.out.println("Length Ratio: "
                + demonstrateDivision(length1, length2));


        // ---------- WEIGHT ----------
        Quantity<WeightUnit> w1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("\nWeight Equal: "
                + demonstrateEquality(w1, w2));

        System.out.println("Weight Sum (kg): "
                + demonstrateAddition(w1, w2));

        System.out.println("Weight Difference (kg): "
                + demonstrateSubtraction(w1, w2));

        System.out.println("Weight Ratio: "
                + demonstrateDivision(w1, w2));


        // ---------- VOLUME ----------
        Quantity<VolumeUnit> v1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        System.out.println("\nVolume Equal: "
                + demonstrateEquality(v1, v2));

        System.out.println("Volume in gallons: "
                + demonstrateConversion(v1, VolumeUnit.GALLON));

        System.out.println("Volume Sum (litre): "
                + demonstrateAddition(v1, v2));

        System.out.println("Volume Difference (litre): "
                + demonstrateSubtraction(v1, v2));

        System.out.println("Volume Ratio: "
                + demonstrateDivision(v1, v2));
    }
}