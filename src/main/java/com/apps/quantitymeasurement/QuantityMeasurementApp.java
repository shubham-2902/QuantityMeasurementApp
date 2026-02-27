package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    //  Generic Equality
    public static <U extends IMeasurable>
    boolean demonstrateEquality(Quantity<U> q1, Quantity<U> q2) {
        return q1.equals(q2);
    }

    //  Generic Conversion
    public static <U extends IMeasurable>
    Quantity<U> demonstrateConversion(Quantity<U> quantity, U targetUnit) {
        return quantity.convertTo(targetUnit);
    }

    // Generic Addition (same unit as first)
    public static <U extends IMeasurable>
    Quantity<U> demonstrateAddition(Quantity<U> q1, Quantity<U> q2) {
        return q1.add(q2);
    }

    //  Generic Addition with target unit
    public static <U extends IMeasurable>
    Quantity<U> demonstrateAddition(Quantity<U> q1, Quantity<U> q2, U targetUnit) {
        return q1.add(q2, targetUnit);
    }

    //  MAIN (for manual testing)
    public static void main(String[] args) {

        Quantity<LengthUnit> length1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> length2 =
                new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("Lengths equal: "
                + demonstrateEquality(length1, length2));

        Quantity<LengthUnit> converted =
                demonstrateConversion(length1, LengthUnit.INCHES);

        System.out.println("Converted: " + converted);

        Quantity<LengthUnit> sum =
                demonstrateAddition(length1, length2, LengthUnit.FEET);

        System.out.println("Sum: " + sum);

        // Weight demo
        Quantity<WeightUnit> w1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("Weights equal: "
                + demonstrateEquality(w1, w2));
        Quantity<WeightUnit> sumWeight =
                demonstrateAddition(w1, w2, WeightUnit.KILOGRAM);
        System.out.println("Sum: "+ sumWeight);
    }
}