package com.calculator.core;

/**
 * Constants class containing mathematical and application constants.
 * 
 * JAVA BEST PRACTICE: 
 * - Constants should be in a dedicated class or interface
 * - Use UPPER_SNAKE_CASE for constant names
 * - Make the class final and constructor private (utility class pattern)
 * - Constants should be public static final
 */
public final class Constants {
    
    // Private constructor prevents instantiation
    private Constants() {
        throw new UnsupportedOperationException("Constants class cannot be instantiated");
    }
    
    // ==================== Mathematical Constants ====================
    
    /**
     * The mathematical constant Pi (π).
     * Ratio of a circle's circumference to its diameter.
     */
    public static final double PI = Math.PI;
    
    /**
     * Euler's number (e).
     * Base of natural logarithms.
     */
    public static final double E = Math.E;
    
    /**
     * The golden ratio (φ).
     * Approximately 1.618033988749895
     */
    public static final double GOLDEN_RATIO = (1 + Math.sqrt(5)) / 2;
    
    /**
     * Square root of 2.
     * Approximately 1.4142135623730951
     */
    public static final double SQRT_2 = Math.sqrt(2);
    
    /**
     * Square root of 3.
     * Approximately 1.7320508075688772
     */
    public static final double SQRT_3 = Math.sqrt(3);
    
    // ==================== Conversion Constants ====================
    
    /**
     * Degrees to radians conversion factor.
     * Multiply degrees by this to get radians.
     */
    public static final double DEGREES_TO_RADIANS = Math.PI / 180.0;
    
    /**
     * Radians to degrees conversion factor.
     * Multiply radians by this to get degrees.
     */
    public static final double RADIANS_TO_DEGREES = 180.0 / Math.PI;
    
    // ==================== Application Constants ====================
    
    /**
     * Application name.
     */
    public static final String APP_NAME = "Scientific Calculator";
    
    /**
     * Application version.
     */
    public static final String APP_VERSION = "1.0";
    
    /**
     * Maximum factorial input (to prevent overflow).
     */
    public static final int MAX_FACTORIAL_INPUT = 170;
    
    /**
     * Default history size.
     */
    public static final int DEFAULT_HISTORY_SIZE = 50;
    
    /**
     * Tolerance for floating-point comparisons.
     * Used when comparing doubles for equality.
     */
    public static final double EPSILON = 1e-10;
}

