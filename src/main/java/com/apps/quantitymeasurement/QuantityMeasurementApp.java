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
    

        public static boolean demonstrateWeightEquality(Weight w1, Weight w2) {
            return w1.equals(w2);
        }

        public static boolean demonstrateWeightComparison(
                double value1, WeightUnit unit1,
                double value2, WeightUnit unit2) {

            Weight w1 = new Weight(value1, unit1);
            Weight w2 = new Weight(value2, unit2);

            return w1.equals(w2);
        }

        public static Weight demonstrateWeightConversion(
                double value,
                WeightUnit fromUnit,
                WeightUnit toUnit) {

            Weight w = new Weight(value, fromUnit);
            return w.convertTo(toUnit);
        }

        public static Weight demonstrateWeightConversion(
                Weight weight,
                WeightUnit toUnit) {

            return weight.convertTo(toUnit);
        }

        public static Weight demonstrateWeightAddition(Weight w1, Weight w2) {
            return w1.add(w2);
        }

        public static Weight demonstrateWeightAddition(
                Weight w1, Weight w2, WeightUnit targetUnit) {

            return w1.add(w2, targetUnit);
        }
    

    public static void main(String[] args) {

        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length result = demonstrateLengthAddition(
                l1, l2, LengthUnit.FEET);
        
        Weight w1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000.0, WeightUnit.GRAM);
        
        Weight answer = demonstrateWeightAddition(w1, w2, WeightUnit.KILOGRAM);
        


        System.out.println("Result = " + result);
        System.out.println("Result = " + answer);
        
    }
}