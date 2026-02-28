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
        
    
    
    
   
        @Test
        public void testEquality_LitreToLitre_SameValue() {
            Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
            Quantity<VolumeUnit> b = new Quantity<>(1.0, VolumeUnit.LITRE);
            assertTrue(a.equals(b));
        }

        @Test
        public void testEquality_LitreToLitre_DifferentValue() {
            Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
            Quantity<VolumeUnit> b = new Quantity<>(2.0, VolumeUnit.LITRE);
            assertFalse(a.equals(b));
        }

        @Test
        public void testEquality_LitreToMillilitre_EquivalentValue() {
            Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
            Quantity<VolumeUnit> b = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
            assertTrue(a.equals(b));
        }

        @Test
        public void testEquality_MillilitreToLitre_EquivalentValue() {
            Quantity<VolumeUnit> a = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
            Quantity<VolumeUnit> b = new Quantity<>(1.0, VolumeUnit.LITRE);
            assertTrue(a.equals(b));
        }

        @Test
        public void testEquality_LitreToGallon_EquivalentValue() {
            Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
            Quantity<VolumeUnit> b = new Quantity<>(0.264172, VolumeUnit.GALLON);
            assertTrue(a.equals(b));
        }

        @Test
        public void testEquality_GallonToLitre_EquivalentValue() {
            Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.GALLON);
            Quantity<VolumeUnit> b = new Quantity<>(3.78541, VolumeUnit.LITRE);
            assertTrue(a.equals(b));
        }

        @Test
        public void testEquality_NullComparison() {
            Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
            assertFalse(a.equals(null));
        }

        @Test
        public void testEquality_SameReference() {
            Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
            assertTrue(a.equals(a));
        }

        @Test
        public void testEquality_NullUnit() {
            assertThrows(IllegalArgumentException.class,
                    () -> new Quantity<>(1.0, null));
        }

        @Test
        public void testEquality_ZeroValue() {
            Quantity<VolumeUnit> a = new Quantity<>(0.0, VolumeUnit.LITRE);
            Quantity<VolumeUnit> b = new Quantity<>(0.0, VolumeUnit.MILLILITRE);
            assertTrue(a.equals(b));
        }

        @Test
        public void testEquality_NegativeVolume() {
            Quantity<VolumeUnit> a = new Quantity<>(-1.0, VolumeUnit.LITRE);
            Quantity<VolumeUnit> b = new Quantity<>(-1000.0, VolumeUnit.MILLILITRE);
            assertTrue(a.equals(b));
        }

        @Test
        public void testEquality_LargeVolumeValue() {
            Quantity<VolumeUnit> a = new Quantity<>(1000.0, VolumeUnit.LITRE);
            Quantity<VolumeUnit> b = new Quantity<>(1_000_000.0, VolumeUnit.MILLILITRE);
            assertTrue(a.equals(b));
        }

        @Test
        public void testEquality_SmallVolumeValue() {
            Quantity<VolumeUnit> a = new Quantity<>(0.001, VolumeUnit.LITRE);
            Quantity<VolumeUnit> b = new Quantity<>(1.0, VolumeUnit.MILLILITRE);
            assertTrue(a.equals(b));
        }

        // -------------------- Conversion Tests --------------------

        @Test
        public void testConversion_LitreToMillilitre() {
            Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
            Quantity<VolumeUnit> result = a.convertTo(VolumeUnit.MILLILITRE);
            assertEquals(1000.0, result.getValue(), 1e-6);
        }

        @Test
        public void testConversion_MillilitreToLitre() {
            Quantity<VolumeUnit> a = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
            Quantity<VolumeUnit> result = a.convertTo(VolumeUnit.LITRE);
            assertEquals(1.0, result.getValue(), 1e-6);
        }

        @Test
        public void testConversion_GallonToLitre() {
            Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.GALLON);
            Quantity<VolumeUnit> result = a.convertTo(VolumeUnit.LITRE);
            assertEquals(3.78541, result.getValue(), 1e-6);
        }

        @Test
        public void testConversion_LitreToGallon() {
            Quantity<VolumeUnit> a = new Quantity<>(3.78541, VolumeUnit.LITRE);
            Quantity<VolumeUnit> result = a.convertTo(VolumeUnit.GALLON);
            assertEquals(1.0, result.getValue(), 1e-6);
        }

        @Test
        public void testConversion_MillilitreToGallon() {
            Quantity<VolumeUnit> a = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
            Quantity<VolumeUnit> result = a.convertTo(VolumeUnit.GALLON);
            assertEquals(0.264172, result.getValue(), 1e-6);
        }

        @Test
        public void testConversion_SameUnit() {
            Quantity<VolumeUnit> a = new Quantity<>(5.0, VolumeUnit.LITRE);
            Quantity<VolumeUnit> result = a.convertTo(VolumeUnit.LITRE);
            assertEquals(5.0, result.getValue(), 1e-6);
        }

        @Test
        public void testConversion_ZeroValue() {
            Quantity<VolumeUnit> a = new Quantity<>(0.0, VolumeUnit.LITRE);
            Quantity<VolumeUnit> result = a.convertTo(VolumeUnit.MILLILITRE);
            assertEquals(0.0, result.getValue(), 1e-6);
        }

        @Test
        public void testConversion_NegativeValue() {
            Quantity<VolumeUnit> a = new Quantity<>(-1.0, VolumeUnit.LITRE);
            Quantity<VolumeUnit> result = a.convertTo(VolumeUnit.MILLILITRE);
            assertEquals(-1000.0, result.getValue(), 1e-6);
        }

        @Test
        public void testConversion_RoundTrip() {
            Quantity<VolumeUnit> a = new Quantity<>(1.5, VolumeUnit.LITRE);
            Quantity<VolumeUnit> result =
                    a.convertTo(VolumeUnit.MILLILITRE).convertTo(VolumeUnit.LITRE);
            assertEquals(1.5, result.getValue(), 1e-6);
        }

        // -------------------- Addition Tests --------------------

        @Test
        public void testAddition_SameUnit_LitrePlusLitre() {
            Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
            Quantity<VolumeUnit> b = new Quantity<>(2.0, VolumeUnit.LITRE);
            Quantity<VolumeUnit> result = a.add(b);
            assertEquals(3.0, result.getValue(), 1e-6);
        }

        @Test
        public void testAddition_SameUnit_MillilitrePlusMillilitre() {
            Quantity<VolumeUnit> a = new Quantity<>(500.0, VolumeUnit.MILLILITRE);
            Quantity<VolumeUnit> b = new Quantity<>(500.0, VolumeUnit.MILLILITRE);
            Quantity<VolumeUnit> result = a.add(b);
            assertEquals(1000.0, result.getValue(), 1e-6);
        }

        @Test
        public void testAddition_CrossUnit_LitrePlusMillilitre() {
            Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
            Quantity<VolumeUnit> b = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
            Quantity<VolumeUnit> result = a.add(b);
            assertEquals(2.0, result.getValue(), 1e-6);
        }

        @Test
        public void testAddition_CrossUnit_MillilitrePlusLitre() {
            Quantity<VolumeUnit> a = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
            Quantity<VolumeUnit> b = new Quantity<>(1.0, VolumeUnit.LITRE);
            Quantity<VolumeUnit> result = a.add(b);
            assertEquals(2000.0, result.getValue(), 1e-6);
        }

        @Test
        public void testAddition_CrossUnit_GallonPlusLitre() {
            Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.GALLON);
            Quantity<VolumeUnit> b = new Quantity<>(3.78541, VolumeUnit.LITRE);
            Quantity<VolumeUnit> result = a.add(b);
            assertEquals(2.0, result.getValue(), 1e-6);
        }

        @Test
        public void testAddition_ExplicitTargetUnit_Litre() {
            Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
            Quantity<VolumeUnit> b = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
            Quantity<VolumeUnit> result = a.add(b, VolumeUnit.LITRE);
            assertEquals(2.0, result.getValue(), 1e-6);
        }

        @Test
        public void testAddition_ExplicitTargetUnit_Millilitre() {
            Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
            Quantity<VolumeUnit> b = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
            Quantity<VolumeUnit> result = a.add(b, VolumeUnit.MILLILITRE);
            assertEquals(2000.0, result.getValue(), 1e-6);
        }

        @Test
        public void testAddition_ExplicitTargetUnit_Gallon() {
            Quantity<VolumeUnit> a = new Quantity<>(3.78541, VolumeUnit.LITRE);
            Quantity<VolumeUnit> b = new Quantity<>(3.78541, VolumeUnit.LITRE);
            Quantity<VolumeUnit> result = a.add(b, VolumeUnit.GALLON);
            assertEquals(2.0, result.getValue(), 1e-6);
        }

        @Test
        public void testAddition_WithZero() {
            Quantity<VolumeUnit> a = new Quantity<>(5.0, VolumeUnit.LITRE);
            Quantity<VolumeUnit> b = new Quantity<>(0.0, VolumeUnit.MILLILITRE);
            Quantity<VolumeUnit> result = a.add(b);
            assertEquals(5.0, result.getValue(), 1e-6);
        }

        @Test
        public void testAddition_NegativeValues() {
            Quantity<VolumeUnit> a = new Quantity<>(5.0, VolumeUnit.LITRE);
            Quantity<VolumeUnit> b = new Quantity<>(-2000.0, VolumeUnit.MILLILITRE);
            Quantity<VolumeUnit> result = a.add(b);
            assertEquals(3.0, result.getValue(), 1e-6);
        }

        @Test
        public void testAddition_LargeValues() {
            Quantity<VolumeUnit> a = new Quantity<>(1e6, VolumeUnit.LITRE);
            Quantity<VolumeUnit> b = new Quantity<>(1e6, VolumeUnit.LITRE);
            Quantity<VolumeUnit> result = a.add(b);
            assertEquals(2e6, result.getValue(), 1e-6);
        }

        @Test
        public void testAddition_SmallValues() {
            Quantity<VolumeUnit> a = new Quantity<>(0.001, VolumeUnit.LITRE);
            Quantity<VolumeUnit> b = new Quantity<>(0.002, VolumeUnit.LITRE);
            Quantity<VolumeUnit> result = a.add(b);
            assertEquals(0.003, result.getValue(), 1e-6);
        }
    

}