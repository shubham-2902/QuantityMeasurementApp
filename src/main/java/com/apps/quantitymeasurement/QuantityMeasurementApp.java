package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // Generic equality method
    public static boolean demonstrateLengthEquality(
            Length length1,
            Length length2
    ) {
        return length1.equals(length2);
    }

    // Feet equality demo
    public static void demonstrateFeetEquality() {

        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);

        System.out.println("Feet Equal: " +
                demonstrateLengthEquality(l1, l2));
    }

    // Inches equality demo
    public static void demonstrateInchesEquality() {

        Length l1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.INCHES);

        System.out.println("Inches Equal: " +
                demonstrateLengthEquality(l1, l2));
    }

    // Feet vs Inches comparison
    public static void demonstrateFeetInchesComparison() {

        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);

        System.out.println("Feet vs Inches Equal: " +
                demonstrateLengthEquality(feet, inches));
    }

    // Main method
    public static void main(String[] args) {

        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}