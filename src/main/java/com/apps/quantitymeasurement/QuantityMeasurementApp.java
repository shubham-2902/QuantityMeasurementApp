package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // ===== Equality check =====
    public static boolean demonstrateLengthEquality(
            Length length1,
            Length length2) {
        return length1.equals(length2);
    }

    // ===== Comparison using values + units =====
    public static boolean demonstrateLengthComparison(
            double value1, Length.LengthUnit unit1,
            double value2, Length.LengthUnit unit2) {

        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);

        return demonstrateLengthEquality(l1, l2);
    }

    // ===== UC5 Conversion Method (overloaded #1) =====
    public static Length demonstrateLengthConversion(
            double value,
            Length.LengthUnit fromUnit,
            Length.LengthUnit toUnit) {

        Length length = new Length(value, fromUnit);
        return length.convertTo(toUnit);
    }

    // ===== UC5 Conversion Method (overloaded #2) =====
    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit toUnit) {

        return length.convertTo(toUnit);
    }

    // ===== MAIN METHOD (Demo Only) =====
    public static void main(String[] args) {

        // Example conversions
        System.out.println(
                demonstrateLengthConversion(
                        1.0,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES));

        System.out.println(
                demonstrateLengthConversion(
                        3.0,
                        Length.LengthUnit.YARDS,
                        Length.LengthUnit.FEET));

        System.out.println(
                demonstrateLengthConversion(
                        36.0,
                        Length.LengthUnit.INCHES,
                        Length.LengthUnit.YARDS));

        System.out.println(
                demonstrateLengthConversion(
                        1.0,
                        Length.LengthUnit.CENTIMETERS,
                        Length.LengthUnit.INCHES));
        System.out.println(
                demonstrateLengthConversion(
                        0.0,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES));
    }
}