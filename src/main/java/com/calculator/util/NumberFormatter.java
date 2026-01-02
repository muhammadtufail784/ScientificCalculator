package com.calculator.util;

import java.text.DecimalFormat;

/**
 * NumberFormatter utility class for formatting numbers in a user-friendly way.
 * Removes unnecessary trailing zeros and handles special cases.
 * 
 * JAVA BEST PRACTICE: Utility classes should have private constructors
 * to prevent instantiation and all methods should be static.
 */
public final class NumberFormatter {
    
    // Private constructor prevents instantiation (Java Best Practice)
    private NumberFormatter() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
    
    // Decimal format for standard numbers (up to 10 decimal places)
    private static final DecimalFormat STANDARD_FORMAT = new DecimalFormat("#.##########");
    
    // Decimal format for scientific notation (very large/small numbers)
    private static final DecimalFormat SCIENTIFIC_FORMAT = new DecimalFormat("0.######E0");
    
    // Threshold for switching to scientific notation
    private static final double SCIENTIFIC_THRESHOLD_HIGH = 1e10;
    private static final double SCIENTIFIC_THRESHOLD_LOW = 1e-6;
    
    /**
     * Formats a double value for display.
     * - Removes unnecessary trailing zeros
     * - Uses scientific notation for very large/small numbers
     * - Handles special values (NaN, Infinity)
     * 
     * @param value The number to format
     * @return Formatted string representation
     */
    public static String format(double value) {
        // Handle special cases
        if (Double.isNaN(value)) {
            return "NaN (Not a Number)";
        }
        if (Double.isInfinite(value)) {
            return value > 0 ? "Infinity" : "-Infinity";
        }
        
        // Check if the value is a whole number
        if (value == Math.floor(value) && Math.abs(value) < Long.MAX_VALUE) {
            return String.valueOf((long) value);
        }
        
        // Use scientific notation for very large or very small numbers
        double absValue = Math.abs(value);
        if (absValue != 0 && (absValue >= SCIENTIFIC_THRESHOLD_HIGH || absValue < SCIENTIFIC_THRESHOLD_LOW)) {
            return SCIENTIFIC_FORMAT.format(value);
        }
        
        // Standard formatting
        return STANDARD_FORMAT.format(value);
    }
    
    /**
     * Formats a number with a specific number of decimal places.
     * 
     * @param value The number to format
     * @param decimalPlaces Number of decimal places
     * @return Formatted string representation
     */
    public static String format(double value, int decimalPlaces) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            return format(value);
        }
        
        StringBuilder pattern = new StringBuilder("#.");
        for (int i = 0; i < decimalPlaces; i++) {
            pattern.append("#");
        }
        
        DecimalFormat df = new DecimalFormat(pattern.toString());
        return df.format(value);
    }
    
    /**
     * Checks if a double value represents a whole number.
     * 
     * @param value The number to check
     * @return true if the value is a whole number
     */
    public static boolean isWholeNumber(double value) {
        return value == Math.floor(value) && !Double.isInfinite(value);
    }
}

