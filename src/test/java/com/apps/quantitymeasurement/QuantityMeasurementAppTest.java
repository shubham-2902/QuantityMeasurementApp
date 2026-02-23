package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ===== UC1/UC2/UC3 COMPATIBILITY =====

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

    // ===== UC4 — YARDS SUPPORT =====

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

    // ===== UC4 — CENTIMETERS SUPPORT =====

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

    @Test
    public void centimetersNotEqualToFeet() {
        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        assertFalse(cm.equals(feet));
    }

    // ===== EQUALITY CONTRACT TESTS =====

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

        // Reflexive
        assertTrue(a.equals(a));

        // Symmetric
        assertTrue(a.equals(b));
        assertTrue(b.equals(a));

        // Transitive
        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
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
}