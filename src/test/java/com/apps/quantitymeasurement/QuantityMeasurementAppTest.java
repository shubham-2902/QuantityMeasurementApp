package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // Basic test cases for UC-1 ,UC-2 and UC-3

    @Test
    public void testFeetEquality() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testInchesEquality() {
        Length l1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testFeetInchesComparison() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    public void testFeetInequality() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(2.0, Length.LengthUnit.FEET);
        assertFalse(l1.equals(l2));
    }

    @Test
    public void testInchesInequality() {
        Length l1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(2.0, Length.LengthUnit.INCHES);
        assertFalse(l1.equals(l2));
    }

    @Test
    public void testCrossUnitInequality() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(10.0, Length.LengthUnit.INCHES);
        assertFalse(feet.equals(inches));
    }

    @Test
    public void testMultipleFeetComparison() {
        Length l1 = new Length(2.0, Length.LengthUnit.FEET);
        Length l2 = new Length(24.0, Length.LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
    }

    // ===== UC4 — YARDS =====

    @Test
    public void yardEquals36Inches() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);
        assertTrue(yard.equals(inches));
    }

    @Test
    public void threeFeetEqualsOneYard() {
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        assertTrue(feet.equals(yard));
    }

    @Test
    public void yardNotEqualToInches() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length inches = new Length(30.0, Length.LengthUnit.INCHES);
        assertFalse(yard.equals(inches));
    }

    // ===== UC4 — CENTIMETERS =====

    @Test
    public void centimeterEquals39Point3701Inches() {
        Length cm = new Length(100.0, Length.LengthUnit.CENTIMETERS);
        Length inches = new Length(39.3701, Length.LengthUnit.INCHES);
        assertTrue(cm.equals(inches));
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {
        Length cm = new Length(30.48, Length.LengthUnit.CENTIMETERS);
        Length foot = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(cm.equals(foot));
    }

    // ===== EQUALITY CONTRACT =====

    @Test
    public void referenceEqualitySameObject() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(l1.equals(l1));
    }

    @Test
    public void equalsReturnsFalseForNull() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        assertFalse(l1.equals(null));
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {

        Length a = new Length(1.0, Length.LengthUnit.YARDS);
        Length b = new Length(3.0, Length.LengthUnit.FEET);
        Length c = new Length(36.0, Length.LengthUnit.INCHES);

        assertTrue(a.equals(a));   // reflexive
        assertTrue(a.equals(b));   // symmetric
        assertTrue(b.equals(a));
        assertTrue(b.equals(c));   // transitive
        assertTrue(a.equals(c));
    }

    @Test
    public void differentValuesSameUnitNotEqual() {
        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(6.0, Length.LengthUnit.FEET);
        assertFalse(l1.equals(l2));
    }

    @Test
    public void crossUnitEqualityDemonstrateMethod() {
        Length l1 = new Length(2.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(6.0, Length.LengthUnit.FEET);
        assertTrue(l1.equals(l2));
    }

    // ===== UC5 — CONVERSION TESTS =====

    @Test
    public void convertFeetToInches() {
        Length result = QuantityMeasurementApp
                .demonstrateLengthConversion(
                        3.0,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES);

        Length expected =
                new Length(36.0, Length.LengthUnit.INCHES);

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(result, expected)
        );
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod() {
        Length yards = new Length(2.0, Length.LengthUnit.YARDS);

        Length result = QuantityMeasurementApp
                .demonstrateLengthConversion(
                        yards,
                        Length.LengthUnit.INCHES);

        Length expected =
                new Length(72.0, Length.LengthUnit.INCHES);

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(result, expected)
        );
    }
    @Test
    public void addFeetAndInches() {

        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length sumLength =
                QuantityMeasurementApp.demonstrateLengthAddition(length1, length2);

        Length expectedLength =
                new Length(2.0, Length.LengthUnit.FEET);

        assertTrue(
            QuantityMeasurementApp.demonstrateLengthEquality(sumLength, expectedLength)
        );
    }
    @Test
    public void addFeetAndInchesWithTargetUnitInches() {

        // Arrange
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);

        // Act
        Length sumLength = QuantityMeasurementApp
                .demonstrateLengthAddition(
                        length1,
                        length2,
                        Length.LengthUnit.INCHES);

        // Expected: 1 foot + 12 inches = 24 inches
        Length expectedLength =
                new Length(24.0, Length.LengthUnit.INCHES);

        // Assert
        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(
                                sumLength,
                                expectedLength));
    }
}