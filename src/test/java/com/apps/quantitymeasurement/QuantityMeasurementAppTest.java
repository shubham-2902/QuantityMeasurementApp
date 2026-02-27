package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    
    // Tests for Generalized Quantity
    

    @Test
    public void lengthFeetEqualsInches() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(12.0, LengthUnit.INCHES);
        assertTrue(a.equals(b));
    }

    @Test
    public void lengthYardsEqualsFeet() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.YARDS);
        Quantity<LengthUnit> b = new Quantity<>(3.0, LengthUnit.FEET);
        assertTrue(a.equals(b));
    }

    @Test
    public void weightKilogramEqualsGrams() {
        Quantity<WeightUnit> a = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> b = new Quantity<>(1000.0, WeightUnit.GRAM);
        assertTrue(a.equals(b));
    }

    @Test
    public void weightPoundEqualsGrams() {
        Quantity<WeightUnit> a = new Quantity<>(1.0, WeightUnit.POUND);
        Quantity<WeightUnit> b = new Quantity<>(453.592, WeightUnit.GRAM);
        assertTrue(a.equals(b));
    }

    // ===============================
    // Conversion Tests
    // ===============================

    @Test
    public void convertLengthFeetToInches() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = a.convertTo(LengthUnit.INCHES);
        assertEquals(12.0, result.getValue(), 1e-6);
    }

    @Test
    public void addLengthFeetAndInches() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = a.add(b);

        assertEquals(2.0, result.getValue(), 1e-6);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void addWeightKilogramsAndGrams() {
        Quantity<WeightUnit> a = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> b = new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result = a.add(b);

        assertEquals(2.0, result.getValue(), 1e-6);
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    // ===============================
    // Generic Type Safety Tests
    // ===============================

    @Test
    public void testGenericTypeSafetyWithWeight() {
        Quantity<WeightUnit> a = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> b = new Quantity<>(2000.0, WeightUnit.GRAM);

        assertTrue(a.equals(b));
    }

    @Test
    public void convertWeightKilogramsToGrams() {
        Quantity<WeightUnit> a = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> result = a.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.getValue(), 1e-6);
    }

    @Test
    public void addWeightKilogramsAndPounds() {
        Quantity<WeightUnit> a = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> b = new Quantity<>(2.20462, WeightUnit.POUND);

        Quantity<WeightUnit> result = a.add(b);

        assertEquals(2.0, result.getValue(), 1e-2); // tolerance for conversion
    }

    @Test
    public void convertLengthYardsToInches() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.YARDS);
        Quantity<LengthUnit> result = a.convertTo(LengthUnit.INCHES);

        assertEquals(36.0, result.getValue(), 1e-6);
    }

  
    // Cross-Type Negative Tests
   

    @Test
    public void preventCrossTypeComparisonLengthVsWeight() {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertFalse(length.equals(weight));
    }

    @Test
    public void preventCrossTypeAdditionLengthVsWeight() {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertThrows(IllegalArgumentException.class, () -> {
            length.add((Quantity) weight);
        });
    }

    // ===================================================
    // UC10 — Additional Tests (Backward Compatibility Set)
    // ===================================================

    @Test
    public void preventCrossTypeConversionLengthToWeight() {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> {
            length.convertTo((LengthUnit) null);
        });
    }

    @Test
    public void addLengthYardsAndFeet() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.YARDS);
        Quantity<LengthUnit> b = new Quantity<>(3.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = a.add(b);

        assertEquals(2.0, result.getValue(), 1e-6);
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }

    @Test
    public void addWeightTonnesAndKilograms() {
        Quantity<WeightUnit> a = new Quantity<>(1.0, WeightUnit.TONNE);
        Quantity<WeightUnit> b = new Quantity<>(1000.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result = a.add(b);

        assertEquals(2.0, result.getValue(), 1e-6);
        assertEquals(WeightUnit.TONNE, result.getUnit());
    }

    // ===============================
    // Backward Compatibility Tests
    // ===============================

    @Test
    public void backwardCompatibilityLengthFeetEqualsInches() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(12.0, LengthUnit.INCHES);
        assertTrue(a.equals(b));
    }

    @Test
    public void backwardCompatibilityWeightKilogramEqualsGrams() {
        Quantity<WeightUnit> a = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> b = new Quantity<>(1000.0, WeightUnit.GRAM);
        assertTrue(a.equals(b));
    }

    @Test
    public void backwardCompatibilityConvertLengthFeetToInches() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = a.convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.getValue(), 1e-6);
    }

    @Test
    public void backwardCompatibilityConvertWeightKilogramsToGrams() {
        Quantity<WeightUnit> a = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> result = a.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.getValue(), 1e-6);
    }

    @Test
    public void backwardCompatibilityAddLengthInSameUnit() {
        Quantity<LengthUnit> a = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(3.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = a.add(b);

        assertEquals(5.0, result.getValue(), 1e-6);
    }

    @Test
    public void backwardCompatibilityAddWeightInSameUnit() {
        Quantity<WeightUnit> a = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> b = new Quantity<>(3.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result = a.add(b);

        assertEquals(5.0, result.getValue(), 1e-6);
    }

    @Test
    public void backwardCompatibilityLengthYardsEqualsFeet() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.YARDS);
        Quantity<LengthUnit> b = new Quantity<>(3.0, LengthUnit.FEET);
        assertTrue(a.equals(b));
    }

    @Test
    public void backwardCompatibilityWeightPoundEqualsGrams() {
        Quantity<WeightUnit> a = new Quantity<>(1.0, WeightUnit.POUND);
        Quantity<WeightUnit> b = new Quantity<>(453.592, WeightUnit.GRAM);
        assertTrue(a.equals(b));
    }

    @Test
    public void backwardCompatibilityChainedAdditionsLength() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> c = new Quantity<>(1.0, LengthUnit.YARDS);

        Quantity<LengthUnit> result = a.add(b).add(c);

        assertEquals(5.0, result.getValue(), 1e-6);
    }
}