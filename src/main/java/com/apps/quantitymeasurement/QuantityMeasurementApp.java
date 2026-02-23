package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(
            Length length1,
            Length length2) {
        return length1.equals(length2);
    }

    public static boolean demonstrateLengthComparison(
            double value1, Length.LengthUnit unit1,
            double value2, Length.LengthUnit unit2) {

        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);

        return demonstrateLengthEquality(l1, l2);
    }

    public static void main(String[] args) {

        // Feet ->Inches
        System.out.println(
                demonstrateLengthComparison(1.0,
                        Length.LengthUnit.FEET,
                        12.0,
                        Length.LengthUnit.INCHES));

        // Yards -> Inches
        System.out.println(
                demonstrateLengthComparison(1.0,
                        Length.LengthUnit.YARDS,
                        36.0,
                        Length.LengthUnit.INCHES));

        // Centimeters -> Inches
        System.out.println(
                demonstrateLengthComparison(100.0,
                        Length.LengthUnit.CENTIMETERS,
                        39.3701,
                        Length.LengthUnit.INCHES));

        // Feet -> Yards
        System.out.println(
                demonstrateLengthComparison(3.0,
                        Length.LengthUnit.FEET,
                        1.0,
                        Length.LengthUnit.YARDS));
    }
}