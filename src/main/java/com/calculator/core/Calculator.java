package com.calculator.core;

/**
 * Calculator class providing basic arithmetic operations.
 * Handles addition, subtraction, multiplication, division, and modulus.
 */
public class Calculator {
    
    private double memory;
    private double lastResult;
    
    public Calculator() {
        this.memory = 0.0;
        this.lastResult = 0.0;
    }
    
    // ==================== Basic Arithmetic Operations ===========================
    
    /**
     * Adds two numbers.
     * @param a First operand
     * @param b Second operand
     * @return Sum of a and b
     */
    public double add(double a, double b) {
        lastResult = a + b;
        return lastResult;
    }
    
    /**
     * Subtracts second number from first.
     * @param a First operand
     * @param b Second operand
     * @return Difference of a and b
     */
    public double subtract(double a, double b) {
        lastResult = a - b;
        return lastResult;
    }
    
    /**
     * Multiplies two numbers.
     * @param a First operand
     * @param b Second operand
     * @return Product of a and b
     */
    public double multiply(double a, double b) {
        lastResult = a * b;
        return lastResult;
    }
    
    /**
     * Divides first number by second.
     * @param a Dividend
     * @param b Divisor
     * @return Quotient of a divided by b
     * @throws ArithmeticException if divisor is zero
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Error: Division by zero is not allowed.");
        }
        lastResult = a / b;
        return lastResult;
    }
    
    /**
     * Calculates modulus (remainder) of division.
     * @param a Dividend
     * @param b Divisor
     * @return Remainder of a divided by b
     * @throws ArithmeticException if divisor is zero
     */
    public double modulus(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Error: Modulus by zero is not allowed.");
        }
        lastResult = a % b;
        return lastResult;
    }
    
    /**
     * Calculates the absolute value.
     * @param a Input number
     * @return Absolute value of a
     */
    public double absolute(double a) {
        lastResult = Math.abs(a);
        return lastResult;
    }
    
    /**
     * Negates a number.
     * @param a Input number
     * @return Negated value of a
     */
    public double negate(double a) {
        lastResult = -a;
        return lastResult;
    }
    
    // ==================== Memory Operations ====================
    
    /**
     * Stores value in memory.
     * @param value Value to store
     */
    public void memoryStore(double value) {
        this.memory = value;
    }
    
    /**
     * Recalls value from memory.
     * @return Stored memory value
     */
    public double memoryRecall() {
        return this.memory;
    }
    
    /**
     * Adds value to memory.
     * @param value Value to add to memory
     */
    public void memoryAdd(double value) {
        this.memory += value;
    }
    
    /**
     * Subtracts value from memory.
     * @param value Value to subtract from memory
     */
    public void memorySubtract(double value) {
        this.memory -= value;
    }
    
    /**
     * Clears memory.
     */
    public void memoryClear() {
        this.memory = 0.0;
    }
    
    // ==================== Getters ====================
    
    /**
     * Gets the last calculated result.
     * @return Last result
     */
    public double getLastResult() {
        return lastResult;
    }
    
    /**
     * Gets current memory value.
     * @return Memory value
     */
    public double getMemory() {
        return memory;
    }
}

