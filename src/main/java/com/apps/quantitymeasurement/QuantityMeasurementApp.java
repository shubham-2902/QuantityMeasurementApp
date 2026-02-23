package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // ---------- Equality ----------
    public static boolean demonstrateLengthEquality(
            Length length1, Length length2) {

        boolean result = length1.equals(length2);

        if (result)
            System.out.println("The two length measurements are equal.");
        else
            System.out.println("The two length measurements are not equal.");

        return result;
    }

    // ---------- Comparison ----------
    public static boolean demonstrateLengthComparison(
            double value1, Length.LengthUnit unit1,
            double value2, Length.LengthUnit unit2) {

        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);

        return demonstrateLengthEquality(l1, l2);
    }

    // ---------- Conversion ----------
    public static Length demonstrateLengthConversion(
            double value,
            Length.LengthUnit fromUnit,
            Length.LengthUnit toUnit) {

        Length length = new Length(value, fromUnit);
        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit toUnit) {

        return length.convertTo(toUnit);
    }

    
    public static Length demonstrateLengthAddition(
            Length length1, Length length2) {

        Length result = length1.add(length2);

        System.out.println("Sum = " + result);

        return result;
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {

        // Example from UC6 description
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        demonstrateLengthAddition(l1, l2); // -> 2 FEET
       
    }
}