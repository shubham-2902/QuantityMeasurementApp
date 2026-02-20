package com.apps.quantitymeasurement;

import java.util.Scanner;

public class QuantityMeasurementApp {

    // Inner class to represent Feet measurement
    public static class Feet {

        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            // Reference check
            if (this == obj) return true;

            // Null check
            if (obj == null) return false;

            // Type check
            if (getClass() != obj.getClass()) return false;

            // Cast and compare values
            Feet other = (Feet) obj;

            return Double.compare(this.value, other.value) == 0;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter first value in feet: ");
            double value1 = sc.nextDouble();

            System.out.print("Enter second value in feet: ");
            double value2 = sc.nextDouble();

            Feet f1 = new Feet(value1);
            Feet f2 = new Feet(value2);

            if (f1.equals(f2)) {
                System.out.println("Equal (true)");
            } else {
                System.out.println("Not Equal (false)");
            }

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter numeric values.");
        }

        sc.close();
    }
}