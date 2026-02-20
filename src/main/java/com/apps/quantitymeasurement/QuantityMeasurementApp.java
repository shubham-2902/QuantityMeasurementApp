package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

	// Inner class to represent Feet measurement
	public static class Feet {

		private final double value;

		// Constructor
		public Feet(double value) {
			this.value = value;
		}

		// Override equals() to compare Feet objects
		@Override
		public boolean equals(Object obj) {

			// Reference check (same object)
			if (this == obj)
				return true;

			// Null check
			if (obj == null)
				return false;

			// Type check
			if (getClass() != obj.getClass())
				return false;

			// Cast and value comparison
			Feet other = (Feet) obj;

			return Double.compare(this.value, other.value) == 0;
		}
	}

	// Optional main method for manual testing
	public static void main(String[] args) {

		Feet f1 = new Feet(1.0);
		Feet f2 = new Feet(1.0);

		System.out.println(f1.equals(f2)); // true
	}
}