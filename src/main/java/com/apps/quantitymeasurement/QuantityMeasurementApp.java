package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(
            Length l1, Length l2) {

        return l1.equals(l2);
    }

    public static boolean demonstrateLengthComparison(
            double v1, LengthUnit u1,
            double v2, LengthUnit u2) {

        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);

        return l1.equals(l2);
    }

    public static Length demonstrateLengthConversion(
            double value,
            LengthUnit from,
            LengthUnit to) {

        Length l = new Length(value, from);
        return l.convertTo(to);
    }

    public static Length demonstrateLengthConversion(
            Length length,
            LengthUnit toUnit) {

        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthAddition(
            Length l1,
            Length l2) {

        return l1.add(l2);
    }

    public static Length demonstrateLengthAddition(
            Length l1,
            Length l2,
            LengthUnit targetUnit) {

        return l1.add(l2, targetUnit);
    }

    public static void main(String[] args) {

        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length result = demonstrateLengthAddition(
                l1, l2, LengthUnit.FEET);

        System.out.println("Result = " + result);
    }
}