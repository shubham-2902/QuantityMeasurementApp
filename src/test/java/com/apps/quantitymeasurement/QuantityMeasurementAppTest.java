package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // Basic test cases for UC-1 ,UC-2 and UC-3

    @Test
    public void testFeetEquality() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(1.0, LengthUnit.FEET);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testInchesEquality() {
        Length l1 = new Length(1.0, LengthUnit.INCHES);
        Length l2 = new Length(1.0, LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testFeetInchesComparison() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    public void testFeetInequality() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(2.0, LengthUnit.FEET);
        assertFalse(l1.equals(l2));
    }

    @Test
    public void testInchesInequality() {
        Length l1 = new Length(1.0, LengthUnit.INCHES);
        Length l2 = new Length(2.0, LengthUnit.INCHES);
        assertFalse(l1.equals(l2));
    }

    @Test
    public void testCrossUnitInequality() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(10.0, LengthUnit.INCHES);
        assertFalse(feet.equals(inches));
    }

    @Test
    public void testMultipleFeetComparison() {
        Length l1 = new Length(2.0, LengthUnit.FEET);
        Length l2 = new Length(24.0, LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
    }

    // ===== UC4 — YARDS =====

    @Test
    public void yardEquals36Inches() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length inches = new Length(36.0, LengthUnit.INCHES);
        assertTrue(yard.equals(inches));
    }

    @Test
    public void threeFeetEqualsOneYard() {
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length yard = new Length(1.0, LengthUnit.YARDS);
        assertTrue(feet.equals(yard));
    }

    @Test
    public void yardNotEqualToInches() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length inches = new Length(30.0, LengthUnit.INCHES);
        assertFalse(yard.equals(inches));
    }

    // ===== UC4 — CENTIMETERS =====

    @Test
    public void centimeterEquals39Point3701Inches() {
        Length cm = new Length(100.0, LengthUnit.CENTIMETERS);
        Length inches = new Length(39.3701,LengthUnit.INCHES);
        assertTrue(cm.equals(inches));
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {
        Length cm = new Length(30.48, LengthUnit.CENTIMETERS);
        Length foot = new Length(1.0, LengthUnit.FEET);
        assertTrue(cm.equals(foot));
    }

    // ===== EQUALITY CONTRACT =====

    @Test
    public void referenceEqualitySameObject() {
        Length l1 = new Length(1.0,LengthUnit.FEET);
        assertTrue(l1.equals(l1));
    }

    @Test
    public void equalsReturnsFalseForNull() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        assertFalse(l1.equals(null));
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {

        Length a = new Length(1.0, LengthUnit.YARDS);
        Length b = new Length(3.0, LengthUnit.FEET);
        Length c = new Length(36.0,LengthUnit.INCHES);

        assertTrue(a.equals(a));   // reflexive
        assertTrue(a.equals(b));   // symmetric
        assertTrue(b.equals(a));
        assertTrue(b.equals(c));   // transitive
        assertTrue(a.equals(c));
    }

    @Test
    public void differentValuesSameUnitNotEqual() {
        Length l1 = new Length(5.0, LengthUnit.FEET);
        Length l2 = new Length(6.0, LengthUnit.FEET);
        assertFalse(l1.equals(l2));
    }

    @Test
    public void crossUnitEqualityDemonstrateMethod() {
        Length l1 = new Length(2.0, LengthUnit.YARDS);
        Length l2 = new Length(6.0, LengthUnit.FEET);
        assertTrue(l1.equals(l2));
    }

    // ===== UC5 — CONVERSION TESTS =====

    @Test
    public void convertFeetToInches() {
        Length result = QuantityMeasurementApp
                .demonstrateLengthConversion(
                        3.0,
                        LengthUnit.FEET,
                        LengthUnit.INCHES);

        Length expected =
                new Length(36.0, LengthUnit.INCHES);

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(result, expected)
        );
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod() {
        Length yards = new Length(2.0, LengthUnit.YARDS);

        Length result = QuantityMeasurementApp
                .demonstrateLengthConversion(
                        yards,
                        LengthUnit.INCHES);

        Length expected =
                new Length(72.0, LengthUnit.INCHES);

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(result, expected)
        );
    }
    @Test
    public void addFeetAndInches() {

        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length sumLength =
                QuantityMeasurementApp.demonstrateLengthAddition(length1, length2);

        Length expectedLength =
                new Length(2.0, LengthUnit.FEET);

        assertTrue(
            QuantityMeasurementApp.demonstrateLengthEquality(sumLength, expectedLength)
        );
    }
    @Test
    public void addFeetAndInchesWithTargetUnitInches() {

        // Arrange
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        // Act
        Length sumLength = QuantityMeasurementApp
                .demonstrateLengthAddition(
                        length1,
                        length2,
                        LengthUnit.INCHES);

        // Expected: 1 foot + 12 inches = 24 inches
        Length expectedLength =
                new Length(24.0, LengthUnit.INCHES);

        // Assert
        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(
                                sumLength,
                                expectedLength));
    }
  
       private static final double EPSILON = 1e-6;

        @Test
        public void testEquality_KilogramToKilogram() {

            Weight w1 = new Weight(1.0, WeightUnit.KILOGRAM);
            Weight w2 = new Weight(1.0, WeightUnit.KILOGRAM);

            assertTrue(w1.equals(w2));
        }

        @Test
        public void testEquality_KilogramToGram() {

            Weight w1 = new Weight(1.0, WeightUnit.KILOGRAM);
            Weight w2 = new Weight(1000.0, WeightUnit.GRAM);

            assertTrue(w1.equals(w2));
        }

        @Test
        public void testConversion_KilogramToGram() {

            Weight result = QuantityMeasurementApp
                    .demonstrateWeightConversion(1.0,
                            WeightUnit.KILOGRAM,
                            WeightUnit.GRAM);

            assertEquals(1000.0, result.getValue(), EPSILON);
        }

        @Test
        public void testConversion_PoundToKilogram() {

            Weight result = QuantityMeasurementApp
                    .demonstrateWeightConversion(2.20462,
                            WeightUnit.POUND,
                            WeightUnit.KILOGRAM);

            assertEquals(1.0, result.getValue(), 1e-2);
        }

        @Test
        public void testAddition_SameUnit() {

            Weight w1 = new Weight(1.0, WeightUnit.KILOGRAM);
            Weight w2 = new Weight(2.0, WeightUnit.KILOGRAM);

            Weight result = QuantityMeasurementApp
                    .demonstrateWeightAddition(w1, w2);

            assertEquals(3.0, result.getValue(), EPSILON);
            assertEquals(WeightUnit.KILOGRAM, result.getUnit());
        }

        @Test
        public void testAddition_CrossUnit() {

            Weight w1 = new Weight(1.0, WeightUnit.KILOGRAM);
            Weight w2 = new Weight(1000.0, WeightUnit.GRAM);

            Weight result = QuantityMeasurementApp
                    .demonstrateWeightAddition(w1, w2);

            assertEquals(2.0, result.getValue(), EPSILON);
        }

        @Test
        public void testAddition_WithTargetUnit() {

            Weight w1 = new Weight(1.0, WeightUnit.KILOGRAM);
            Weight w2 = new Weight(1000.0, WeightUnit.GRAM);

            Weight result = QuantityMeasurementApp
                    .demonstrateWeightAddition(
                            w1, w2, WeightUnit.GRAM);

            assertEquals(2000.0, result.getValue(), EPSILON);
            assertEquals(WeightUnit.GRAM, result.getUnit());
        }

        @Test
        public void testAddition_NegativeValue() {

            Weight w1 = new Weight(5.0, WeightUnit.KILOGRAM);
            Weight w2 = new Weight(-2000.0, WeightUnit.GRAM);

            Weight result = QuantityMeasurementApp
                    .demonstrateWeightAddition(w1, w2);

            assertEquals(3.0, result.getValue(), EPSILON);
        }

        @Test
        public void testZeroConversion() {

            Weight result = QuantityMeasurementApp
                    .demonstrateWeightConversion(0.0,
                            WeightUnit.KILOGRAM,
                            WeightUnit.GRAM);

            assertEquals(0.0, result.getValue(), EPSILON);
        }

        @Test
        public void testNullUnitThrows() {

            assertThrows(IllegalArgumentException.class,
                    () -> new Weight(1.0, null));
        }
    }
