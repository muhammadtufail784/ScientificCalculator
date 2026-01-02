package com.calculator.core;

/**
 * ScientificOperations class providing advanced mathematical functions.
 * Includes trigonometric, logarithmic, exponential, and other scientific operations.
 * 
 * JAVA BEST PRACTICES DEMONSTRATED:
 * - Single Responsibility: Each method does one thing
 * - Clear method names that describe what they do
 * - Comprehensive Javadoc documentation
 * - Input validation with descriptive error messages
 * - Use of Java's Math library for accuracy
 */
public class ScientificOperations {
    
    // ==================== Power and Root Operations ====================
    
    /**
     * Raises base to the power of exponent.
     * @param base The base number
     * @param exponent The exponent
     * @return base raised to the power of exponent
     */
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    
    /**
     * Calculates the square of a number.
     * @param a Input number
     * @return Square of a
     */
    public double square(double a) {
        return a * a;
    }
    
    /**
     * Calculates the cube of a number.
     * @param a Input number
     * @return Cube of a
     */
    public double cube(double a) {
        return a * a * a;
    }
    
    /**
     * Calculates the square root of a number.
     * @param a Input number (must be non-negative)
     * @return Square root of a
     * @throws ArithmeticException if input is negative
     */
    public double squareRoot(double a) {
        if (a < 0) {
            throw new ArithmeticException("Error: Cannot calculate square root of negative number.");
        }
        return Math.sqrt(a);
    }
    
    /**
     * Calculates the cube root of a number.
     * @param a Input number
     * @return Cube root of a
     */
    public double cubeRoot(double a) {
        return Math.cbrt(a);
    }
    
    /**
     * Calculates the nth root of a number.
     * @param a Input number
     * @param n Root degree
     * @return nth root of a
     */
    public double nthRoot(double a, double n) {
        if (n == 0) {
            throw new ArithmeticException("Error: Root degree cannot be zero.");
        }
        if (a < 0 && n % 2 == 0) {
            throw new ArithmeticException("Error: Cannot calculate even root of negative number.");
        }
        return Math.pow(a, 1.0 / n);
    }
    
    // ==================== Logarithmic Operations ====================
    
    /**
     * Calculates natural logarithm (base e).
     * @param a Input number (must be positive)
     * @return Natural logarithm of a
     * @throws ArithmeticException if input is non-positive
     */
    public double naturalLog(double a) {
        if (a <= 0) {
            throw new ArithmeticException("Error: Logarithm undefined for non-positive numbers.");
        }
        return Math.log(a);
    }
    
    /**
     * Calculates common logarithm (base 10).
     * @param a Input number (must be positive)
     * @return Log base 10 of a
     * @throws ArithmeticException if input is non-positive
     */
    public double log10(double a) {
        if (a <= 0) {
            throw new ArithmeticException("Error: Logarithm undefined for non-positive numbers.");
        }
        return Math.log10(a);
    }
    
    /**
     * Calculates logarithm with custom base.
     * @param a Input number (must be positive)
     * @param base Logarithm base (must be positive and not 1)
     * @return Log base 'base' of a
     * @throws ArithmeticException if inputs are invalid
     */
    public double logBase(double a, double base) {
        if (a <= 0 || base <= 0) {
            throw new ArithmeticException("Error: Logarithm undefined for non-positive numbers.");
        }
        if (base == 1) {
            throw new ArithmeticException("Error: Logarithm base cannot be 1.");
        }
        return Math.log(a) / Math.log(base);
    }
    
    // ==================== Exponential Operations ====================
    
    /**
     * Calculates e raised to the power of a.
     * @param a Exponent
     * @return e^a
     */
    public double exp(double a) {
        return Math.exp(a);
    }
    
    /**
     * Calculates 10 raised to the power of a.
     * @param a Exponent
     * @return 10^a
     */
    public double exp10(double a) {
        return Math.pow(10, a);
    }
    
    // ==================== Trigonometric Operations (Radians) ====================
    
    /**
     * Calculates sine of angle in radians.
     * @param radians Angle in radians
     * @return Sine of the angle
     */
    public double sin(double radians) {
        return Math.sin(radians);
    }
    
    /**
     * Calculates cosine of angle in radians.
     * @param radians Angle in radians
     * @return Cosine of the angle
     */
    public double cos(double radians) {
        return Math.cos(radians);
    }
    
    /**
     * Calculates tangent of angle in radians.
     * @param radians Angle in radians
     * @return Tangent of the angle
     */
    public double tan(double radians) {
        return Math.tan(radians);
    }
    
    // ==================== Trigonometric Operations (Degrees) ====================
    
    /**
     * Calculates sine of angle in degrees.
     * @param degrees Angle in degrees
     * @return Sine of the angle
     */
    public double sinDeg(double degrees) {
        return Math.sin(Math.toRadians(degrees));
    }
    
    /**
     * Calculates cosine of angle in degrees.
     * @param degrees Angle in degrees
     * @return Cosine of the angle
     */
    public double cosDeg(double degrees) {
        return Math.cos(Math.toRadians(degrees));
    }
    
    /**
     * Calculates tangent of angle in degrees.
     * @param degrees Angle in degrees
     * @return Tangent of the angle
     */
    public double tanDeg(double degrees) {
        return Math.tan(Math.toRadians(degrees));
    }
    
    // ==================== Inverse Trigonometric Operations ====================
    
    /**
     * Calculates arc sine (inverse sine).
     * @param value Input value (must be between -1 and 1)
     * @return Arc sine in radians
     * @throws ArithmeticException if value is out of range
     */
    public double asin(double value) {
        if (value < -1 || value > 1) {
            throw new ArithmeticException("Error: Arc sine input must be between -1 and 1.");
        }
        return Math.asin(value);
    }
    
    /**
     * Calculates arc cosine (inverse cosine).
     * @param value Input value (must be between -1 and 1)
     * @return Arc cosine in radians
     * @throws ArithmeticException if value is out of range
     */
    public double acos(double value) {
        if (value < -1 || value > 1) {
            throw new ArithmeticException("Error: Arc cosine input must be between -1 and 1.");
        }
        return Math.acos(value);
    }
    
    /**
     * Calculates arc tangent (inverse tangent).
     * @param value Input value
     * @return Arc tangent in radians
     */
    public double atan(double value) {
        return Math.atan(value);
    }
    
    // ==================== Hyperbolic Functions ====================
    
    /**
     * Calculates hyperbolic sine.
     * @param a Input value
     * @return Hyperbolic sine of a
     */
    public double sinh(double a) {
        return Math.sinh(a);
    }
    
    /**
     * Calculates hyperbolic cosine.
     * @param a Input value
     * @return Hyperbolic cosine of a
     */
    public double cosh(double a) {
        return Math.cosh(a);
    }
    
    /**
     * Calculates hyperbolic tangent.
     * @param a Input value
     * @return Hyperbolic tangent of a
     */
    public double tanh(double a) {
        return Math.tanh(a);
    }
    
    // ==================== Special Functions ====================
    
    /**
     * Calculates factorial of a non-negative integer.
     * 
     * BEGINNER NOTE: Factorial of n (written as n!) is the product of all
     * positive integers less than or equal to n.
     * Example: 5! = 5 × 4 × 3 × 2 × 1 = 120
     * 
     * @param n Non-negative integer (0 to 170)
     * @return Factorial of n
     * @throws ArithmeticException if n is negative or too large
     */
    public double factorial(int n) {
        // Validate input - factorial is only defined for non-negative integers
        if (n < 0) {
            throw new ArithmeticException("Error: Factorial undefined for negative numbers.");
        }
        // Prevent overflow - 171! exceeds Double.MAX_VALUE
        if (n > Constants.MAX_FACTORIAL_INPUT) {
            throw new ArithmeticException("Error: Factorial too large (maximum input is " 
                + Constants.MAX_FACTORIAL_INPUT + ").");
        }
        
        // Calculate factorial using iterative approach (more efficient than recursion)
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * Calculates permutation P(n, r).
     * @param n Total items
     * @param r Items to arrange
     * @return Number of permutations
     */
    public double permutation(int n, int r) {
        if (n < 0 || r < 0 || r > n) {
            throw new ArithmeticException("Error: Invalid permutation parameters.");
        }
        return factorial(n) / factorial(n - r);
    }
    
    /**
     * Calculates combination C(n, r).
     * @param n Total items
     * @param r Items to choose
     * @return Number of combinations
     */
    public double combination(int n, int r) {
        if (n < 0 || r < 0 || r > n) {
            throw new ArithmeticException("Error: Invalid combination parameters.");
        }
        return factorial(n) / (factorial(r) * factorial(n - r));
    }
    
    /**
     * Calculates the reciprocal (1/x).
     * @param a Input number
     * @return Reciprocal of a
     * @throws ArithmeticException if a is zero
     */
    public double reciprocal(double a) {
        if (a == 0) {
            throw new ArithmeticException("Error: Reciprocal of zero is undefined.");
        }
        return 1.0 / a;
    }
    
    // ==================== Conversion Functions ====================
    
    /**
     * Converts degrees to radians.
     * @param degrees Angle in degrees
     * @return Angle in radians
     */
    public double toRadians(double degrees) {
        return Math.toRadians(degrees);
    }
    
    /**
     * Converts radians to degrees.
     * @param radians Angle in radians
     * @return Angle in degrees
     */
    public double toDegrees(double radians) {
        return Math.toDegrees(radians);
    }
    
    // ==================== Constants ====================
    
    /**
     * Returns the value of Pi (π ≈ 3.14159265358979).
     * Pi is the ratio of a circle's circumference to its diameter.
     * 
     * @return Pi (π)
     */
    public double getPi() {
        return Constants.PI;
    }
    
    /**
     * Returns the value of Euler's number (e ≈ 2.71828182845904).
     * e is the base of natural logarithms.
     * 
     * @return e (Euler's number)
     */
    public double getE() {
        return Constants.E;
    }
    
    /**
     * Returns the golden ratio (φ ≈ 1.61803398874989).
     * The golden ratio appears frequently in geometry, art, and nature.
     * 
     * @return Golden ratio (φ)
     */
    public double getGoldenRatio() {
        return Constants.GOLDEN_RATIO;
    }
}

