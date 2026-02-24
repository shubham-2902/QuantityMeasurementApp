# 📏 QuantityMeasurementApp

> A Java application built using Test-Driven Development (TDD) to systematically design and enhance a quantity measurement system. The project focuses on step-by-step evolution, clean object-oriented principles, and continuous refactoring to create a scalable and maintainable domain model.

## 📖 Overview

- Structured Java project centered around modelling measurement quantities.
- Developed incrementally through well-defined Use Cases to gradually refine the design.
- Prioritizes readability, consistency, and long-term maintainability as the system expands.

### 📂 Project Structure

```
  📦 QuantityMeasurementApp
  │
  ├── 📁 src
  │   ├── 📁 main
  │   │   └── 📁 java
  │   │       └── 📁 com
  │   │           └── 📁 app
  │   │               └── 📁 quantitymeasurement
  │   │                   └── 📄 LengthUnit.java
  │   │                   └── 📄 QuantityMeasurementApp.java
  │   │
  │   └── 📁 test
  │       └── 📁 java
  │           └── 📁 com
  │               └── 📁 app
  │                   └── 📁 quantitymeasurement.test
  │                    
  └── 📘 README.md
```

## ⚙️ Development Approach

> This project adopts a structured and incremental **Test-Driven Development (TDD)** methodology:

- Test cases are created first to clearly define the expected behavior.
- Implementation is written to make the tests pass.
- Each Use Case adds functionality through small, manageable increments.
- Refactoring is performed regularly to improve design without breaking existing behavior.
- The system gradually evolves into a clean, maintainable, and thoroughly tested codebase.

# UC1 – Feet Measurement Equality

## 📌 Description

Implements equality comparison between two numerical values measured in feet using proper `equals()` method implementation.

---

## 🎯 Objective

Return:

- `true` if both feet values are equal  
- `false` otherwise  

---

## 🛠 Implementation

- Inner class `Feet`  
- Encapsulated `private final double value`  
- Immutable design  
- Overridden `equals()` using `Double.compare()`  
- Null and type safety checks  

---

## ✅ Example

**Input:**  
1.0 ft and 1.0 ft  

**Output:**  
Equal: `true`

---

## 🧠 Concepts Covered
- Equality Contract  
- Floating-point comparison  
- Null safety  
- Type safety  
- Encapsulation  
- Unit testing basics  


  ---

  # UC2 – Feet and Inches Measurement Equality

## 📌 Description

Extends UC1 by adding equality comparison for Inches along with Feet. Both measurements are treated separately and compared independently.

---

## 🎯 Objective

Return:

- `true` if two Feet values are equal  
- `true` if two Inches values are equal  
- `false` otherwise  

---

## 🛠 Implementation

- Separate `Feet` and `Inches` classes  
- Encapsulated `private final double value`  
- Immutable design  
- Overridden `equals()` using `Double.compare()`  
- Null and type safety checks  
- Separate static methods for Feet and Inches comparison  

---

## ✅ Example

**Input:**  
1.0 inch and 1.0 inch  

**Output:**  
Equal: `true`  

**Input:**  
1.0 ft and 1.0 ft  

**Output:**  
Equal: `true`  

---

## 🧠 Concepts Covered

- Object Equality Contract  
- Floating-point comparison  
- Null safety  
- Type safety  
- Encapsulation  
- Unit testing best practices  

---

## ⚠️ Limitation

Violates **DRY principle** since `Feet` and `Inches` classes contain duplicated logic.  
A better design would use a **generic Quantity class** or **unit parameter** to reduce redundancy.

---


# UC3 – Generic Quantity Class (DRY Principle)

## 📌 Description

Refactors UC1 and UC2 by replacing separate Feet and Inches classes with a single generic `QuantityLength` class.

Eliminates code duplication and follows the **DRY (Don't Repeat Yourself)** principle while preserving all previous functionality.

---

## 🎯 Objective

- Support equality comparison across units (Feet, Inches)  
- Convert values to a common base unit (feet)  
- Maintain clean, scalable, and maintainable design  

---

## 🛠 Implementation

- `LengthUnit` enum with conversion factors  
- `QuantityLength` class with:
  - `private final double value`  
  - `private final LengthUnit unit`  
- Conversion to base unit before comparison  
- Overridden `equals()` using `Double.compare()`  
- Null and type safety checks  

---

## ✅ Example

**Input:**  
Quantity(1.0, FEET) and Quantity(12.0, INCH)  

**Output:**  
Equal: `true`  

**Input:**  
Quantity(1.0, INCH) and Quantity(1.0, INCH)  

**Output:**  
Equal: `true`  

---

## 🧠 Concepts Covered

- DRY Principle  
- Enum Usage  
- Polymorphism  
- Abstraction  
- Encapsulation  
- Equality Contract  
- Cross-Unit Comparison  
- Single Responsibility Principle  
- Scalable Design  

---

## 🚀 Benefits Over UC1 & UC2

- No duplicated code  
- Centralized conversion logic  
- Easier to add new units  
- Improved maintainability  
- Backward compatibility preserved


---

# UC4 – Extended Unit Support

## 📌 Description

Extends UC3 by adding **YARDS** and **CENTIMETERS** to the generic `QuantityLength` class.

Demonstrates scalability of the DRY-based design.  
New units are added only in the `LengthUnit` enum without modifying the main class logic.

---

## 🎯 Objective

- Support equality across **FEET, INCHES, YARDS, and CENTIMETERS**  
- Convert all values to a common base unit before comparison  
- Maintain backward compatibility (UC1–UC3)  

---

## 🛠 Implementation

- Updated `LengthUnit` enum:
  - `FEET`  
  - `INCHES`  
  - `YARDS` (1 yard = 3 feet)  
  - `CENTIMETERS` (1 cm = 0.393701 inches)  
- No changes required in `QuantityLength` class  
- Centralized conversion logic  
- Overridden `equals()` using `Double.compare()`  

---

## ✅ Example

**Input:**  
Quantity(1.0, YARDS) and Quantity(3.0, FEET)  

**Output:**  
Equal: `true`  

**Input:**  
Quantity(1.0, YARDS) and Quantity(36.0, INCHES)  

**Output:**  
Equal: `true`  

**Input:**  
Quantity(1.0, CENTIMETERS) and Quantity(0.393701, INCHES)  

**Output:**  
Equal: `true`  

---

## 🧠 Concepts Covered

- Scalability of Generic Design  
- DRY Principle Validation  
- Enum Extensibility  
- Cross-Unit Conversion  
- Mathematical Precision  
- Equality Contract  
- Backward Compatibility  

---

## 🌟 Benefits

- No code duplication  
- Easy addition of new units  
- Centralized conversion factors  
- Fully backward compatible  
- Clean, maintainable architecture


---


# UC5 – Unit-to-Unit Conversion (Same Measurement Type)

## 📌 Description

Extends UC4 by adding explicit **unit-to-unit conversion support**.

Provides a public API:

`static double convert(double value, LengthUnit source, LengthUnit target)`

Supports conversion across:

- FEET  
- INCHES  
- YARDS  
- CENTIMETERS  

---

## 🎯 Objective

- Convert between any supported length units  
- Normalize to a base unit before conversion  
- Preserve mathematical accuracy within floating-point precision  

---


# UC6 – Addition of Two Length Units (Same Category)

## 📌 Description

Extends UC5 by introducing **addition operations between length measurements**.

Supports adding two `QuantityLength` objects of possibly different units and returns the result in the unit of the first operand (or specified target unit).

Example: `1 FEET + 12 INCHES = 2 FEET`

---

## 🎯 Objective

- Add two length measurements  
- Normalize to base unit before arithmetic  
- Preserve immutability  
- Maintain floating-point precision  

---

## ➕ Addition Logic

- Validate both operands (non-null, finite values, valid units)  
- Convert both values to base unit  
- Add base values  
- Convert sum to target unit (unit of first operand)  
- Return new `QuantityLength` object  

---

## ✅ Example

- `add(Quantity(1.0, FEET), Quantity(2.0, FEET))`  
  → `Quantity(3.0, FEET)`  

- `add(Quantity(1.0, FEET), Quantity(12.0, INCHES))`  
  → `Quantity(2.0, FEET)`  

- `add(Quantity(12.0, INCHES), Quantity(1.0, FEET))`  
  → `Quantity(24.0, INCHES)`  

- `add(Quantity(1.0, YARDS), Quantity(3.0, FEET))`  
  → `Quantity(2.0, YARDS)`  

- `add(Quantity(2.54, CENTIMETERS), Quantity(1.0, INCHES))`  
  → `Quantity(~5.08, CENTIMETERS)`  

---

## ✨ Features

- Cross-unit addition  
- Same-unit addition  
- Commutative property  
- Identity element (adding zero)  
- Negative value handling  
- Large and small value support  
- Precision-safe floating point arithmetic  
- Immutable result object  

---

## 🛡 Validation Rules

- Null operands throw exception  
- Null or invalid units throw `IllegalArgumentException`  
- NaN or infinite values rejected  

---

## 🧠 Concepts Covered

- Arithmetic on Value Objects  
- Immutability  
- Base Unit Normalization  
- DRY Principle Reuse  
- Method Overloading  
- Exception Handling  
- Mathematical Properties (Commutativity, Identity)  
- Clean API Design  

---

## 🌟 Benefits

- Reuses conversion logic from UC5  
- No code duplication  
- Domain-driven arithmetic behavior  
- Scalable for future measurement operations  
- Backward compatible (UC1–UC5 preserved)  


---

# UC7 – Addition with Target Unit Specification

## 📌 Description

Extends UC6 by allowing the caller to explicitly specify the **target unit** for the addition result.

Instead of defaulting to the unit of the first operand, the result can be expressed in any supported `LengthUnit` (FEET, INCHES, YARDS, CENTIMETERS).

Example: `1 FEET + 12 INCHES in YARDS ≈ 0.667 YARDS`

---

## 🎯 Objective

- Add two length measurements  
- Allow explicit target unit specification  
- Preserve immutability  
- Maintain floating-point precision  
- Keep backward compatibility with UC6  

---

## ➕ Addition Logic

- Validate operands and target unit (non-null, finite values)  
- Convert both operands to base unit  
- Add base values  
- Convert sum to explicitly specified target unit  
- Return new `QuantityLength` object  

---

## ✅ Example

- `add(Quantity(1.0, FEET), Quantity(12.0, INCHES), FEET)`  
  → `Quantity(2.0, FEET)`  

- `add(Quantity(1.0, FEET), Quantity(12.0, INCHES), INCHES)`  
  → `Quantity(24.0, INCHES)`  

- `add(Quantity(1.0, FEET), Quantity(12.0, INCHES), YARDS)`  
  → `Quantity(~0.667, YARDS)`  

- `add(Quantity(36.0, INCHES), Quantity(1.0, YARDS), FEET)`  
  → `Quantity(6.0, FEET)`  

---

## ✨ Features

- Explicit target unit control  
- Cross-unit addition  
- Backward compatibility with implicit `add()`  
- Commutative property preserved  
- Zero and negative value handling  
- Large/small scale conversion support  
- Precision-safe arithmetic  

---

## 🛡 Validation Rules

- Null operands throw exception  
- Null or invalid target unit throws `IllegalArgumentException`  
- NaN or infinite values rejected  
- All units must belong to same measurement category  

---

## 🧠 Concepts Covered

- Method Overloading  
- Explicit Parameter Passing  
- DRY Principle Reuse  
- Base Unit Normalization  
- Immutability  
- API Design Clarity  
- Mathematical Properties (Commutativity)  
- Exception Handling  
- Functional Programming Style  

---

## 🌟 Benefits

- Flexible result representation  
- Clear caller intent  
- Scalable unit system  
- Clean and maintainable architecture  
- Fully backward compatible (UC1–UC6 preserved)
  
