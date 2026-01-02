package com.calculator.util;

import java.util.ArrayList;
import java.util.List;

/**
 * CalculationHistory class for storing and managing calculation history.
 * Maintains a list of past calculations with timestamps.
 */
public class CalculationHistory {
    
    private final List<HistoryEntry> history;
    private final int maxSize;
    
    /**
     * Creates a history with default max size of 50 entries.
     */
    public CalculationHistory() {
        this(50);
    }
    
    /**
     * Creates a history with specified max size.
     * @param maxSize Maximum number of entries to store
     */
    public CalculationHistory(int maxSize) {
        this.history = new ArrayList<>();
        this.maxSize = maxSize;
    }
    
    /**
     * Adds a calculation to history.
     * @param expression The calculation expression (e.g., "5 + 3")
     * @param result The result of the calculation
     */
    public void addEntry(String expression, double result) {
        if (history.size() >= maxSize) {
            history.remove(0); // Remove oldest entry
        }
        history.add(new HistoryEntry(expression, result));
    }
    
    /**
     * Gets all history entries.
     * @return List of history entries
     */
    public List<HistoryEntry> getHistory() {
        return new ArrayList<>(history);
    }
    
    /**
     * Gets the last N entries.
     * @param n Number of entries to retrieve
     * @return List of last N entries
     */
    public List<HistoryEntry> getLastEntries(int n) {
        int size = history.size();
        int start = Math.max(0, size - n);
        return new ArrayList<>(history.subList(start, size));
    }
    
    /**
     * Gets the most recent entry.
     * @return Most recent history entry, or null if empty
     */
    public HistoryEntry getLastEntry() {
        if (history.isEmpty()) {
            return null;
        }
        return history.get(history.size() - 1);
    }
    
    /**
     * Gets entry at specific index.
     * @param index Index of entry (0 = oldest)
     * @return History entry at index
     */
    public HistoryEntry getEntry(int index) {
        if (index < 0 || index >= history.size()) {
            return null;
        }
        return history.get(index);
    }
    
    /**
     * Clears all history.
     */
    public void clear() {
        history.clear();
    }
    
    /**
     * Gets the number of entries in history.
     * @return Number of entries
     */
    public int size() {
        return history.size();
    }
    
    /**
     * Checks if history is empty.
     * @return true if no entries
     */
    public boolean isEmpty() {
        return history.isEmpty();
    }
    
    /**
     * Inner class representing a single history entry.
     */
    public static class HistoryEntry {
        private final String expression;
        private final double result;
        private final long timestamp;
        
        public HistoryEntry(String expression, double result) {
            this.expression = expression;
            this.result = result;
            this.timestamp = System.currentTimeMillis();
        }
        
        public String getExpression() {
            return expression;
        }
        
        public double getResult() {
            return result;
        }
        
        public long getTimestamp() {
            return timestamp;
        }
        
        /**
         * Formats the entry for display.
         * @return Formatted string representation
         */
        @Override
        public String toString() {
            return expression + " = " + result;
        }
        
        /**
         * Formats with index number for display.
         * @param index The index number to display
         * @return Formatted string with index
         */
        public String toStringWithIndex(int index) {
            return String.format("%3d. %s = %s", index, expression, result);
        }
    }
}

