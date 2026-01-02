package com.calculator.ui;

import com.calculator.core.Calculator;
import com.calculator.core.ScientificOperations;
import com.calculator.util.InputHandler;
import com.calculator.util.CalculationHistory;
import com.calculator.util.CalculationHistory.HistoryEntry;

import java.util.List;

/**
 * ConsoleUI class providing the user interface for the calculator.
 * Handles menu display, user interaction, and operation execution.
 */
public class ConsoleUI {
    
    private final Calculator calculator;
    private final ScientificOperations scientific;
    private final InputHandler input;
    private final CalculationHistory history;
    private boolean running;
    
    public ConsoleUI() {
        this.calculator = new Calculator();
        this.scientific = new ScientificOperations();
        this.input = new InputHandler();
        this.history = new CalculationHistory();
        this.running = true;
    }
    
    /**
     * Starts the calculator application.
     */
    public void start() {
        while (running) {
            displayMainMenu();
            int choice = input.readMenuChoice("Enter your choice: ", 0, 7);
            processMainMenuChoice(choice);
        }
        input.close();
        System.out.println("\nThank you for using Scientific Calculator. Goodbye!");
    }
    
    /**
     * Displays the main menu.
     */
    private void displayMainMenu() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│           MAIN MENU                 │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│  1. Basic Arithmetic                │");
        System.out.println("│  2. Scientific Functions            │");
        System.out.println("│  3. Trigonometric Functions         │");
        System.out.println("│  4. Logarithmic Functions           │");
        System.out.println("│  5. Memory Operations               │");
        System.out.println("│  6. Constants                       │");
        System.out.println("│  7. Calculation History             │");
        System.out.println("│  0. Exit                            │");
        System.out.println("└─────────────────────────────────────┘");
    }
    
    /**
     * Processes main menu selection.
     * 
     * JAVA BEST PRACTICE: Always include a default case in switch statements
     * to handle unexpected values, even if input is validated beforehand.
     */
    private void processMainMenuChoice(int choice) {
        switch (choice) {
            case 1:
                basicArithmeticMenu();
                break;
            case 2:
                scientificMenu();
                break;
            case 3:
                trigonometricMenu();
                break;
            case 4:
                logarithmicMenu();
                break;
            case 5:
                memoryMenu();
                break;
            case 6:
                constantsMenu();
                break;
            case 7:
                historyMenu();
                break;
            case 0:
                running = false;
                break;
            default:
                // This should never execute due to input validation,
                // but included as a defensive programming practice
                displayError("Invalid menu option.");
                break;
        }
    }
    
    // ==================== Basic Arithmetic ====================
    
    private void basicArithmeticMenu() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│       BASIC ARITHMETIC              │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│  1. Addition (+)                    │");
        System.out.println("│  2. Subtraction (-)                 │");
        System.out.println("│  3. Multiplication (×)              │");
        System.out.println("│  4. Division (÷)                    │");
        System.out.println("│  5. Modulus (%)                     │");
        System.out.println("│  6. Absolute Value (|x|)            │");
        System.out.println("│  7. Negate (±)                      │");
        System.out.println("│  0. Back to Main Menu               │");
        System.out.println("└─────────────────────────────────────┘");
        
        int choice = input.readMenuChoice("Enter your choice: ", 0, 7);
        
        try {
            double a, b, result;
            String expression;
            switch (choice) {
                case 1:
                    a = input.readDouble("Enter first number: ");
                    b = input.readDouble("Enter second number: ");
                    result = calculator.add(a, b);
                    expression = a + " + " + b;
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 2:
                    a = input.readDouble("Enter first number: ");
                    b = input.readDouble("Enter second number: ");
                    result = calculator.subtract(a, b);
                    expression = a + " - " + b;
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 3:
                    a = input.readDouble("Enter first number: ");
                    b = input.readDouble("Enter second number: ");
                    result = calculator.multiply(a, b);
                    expression = a + " × " + b;
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 4:
                    a = input.readDouble("Enter dividend: ");
                    b = input.readDouble("Enter divisor: ");
                    result = calculator.divide(a, b);
                    expression = a + " ÷ " + b;
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 5:
                    a = input.readDouble("Enter dividend: ");
                    b = input.readDouble("Enter divisor: ");
                    result = calculator.modulus(a, b);
                    expression = a + " % " + b;
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 6:
                    a = input.readDouble("Enter number: ");
                    result = calculator.absolute(a);
                    expression = "|" + a + "|";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 7:
                    a = input.readDouble("Enter number: ");
                    result = calculator.negate(a);
                    expression = "-(" + a + ")";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 0:
                    // Return to main menu - no action needed
                    break;
                default:
                    displayError("Invalid option selected.");
                    break;
            }
        } catch (ArithmeticException e) {
            displayError(e.getMessage());
        }
    }
    
    // ==================== Scientific Functions ====================
    
    private void scientificMenu() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│       SCIENTIFIC FUNCTIONS          │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│  1. Power (x^y)                     │");
        System.out.println("│  2. Square (x²)                     │");
        System.out.println("│  3. Cube (x³)                       │");
        System.out.println("│  4. Square Root (√x)                │");
        System.out.println("│  5. Cube Root (∛x)                  │");
        System.out.println("│  6. Nth Root (ⁿ√x)                  │");
        System.out.println("│  7. Reciprocal (1/x)                │");
        System.out.println("│  8. Factorial (n!)                  │");
        System.out.println("│  9. Permutation P(n,r)              │");
        System.out.println("│ 10. Combination C(n,r)              │");
        System.out.println("│  0. Back to Main Menu               │");
        System.out.println("└─────────────────────────────────────┘");
        
        int choice = input.readMenuChoice("Enter your choice: ", 0, 10);
        
        try {
            double a, b, result;
            int n, r;
            String expression;
            switch (choice) {
                case 1:
                    a = input.readDouble("Enter base: ");
                    b = input.readDouble("Enter exponent: ");
                    result = scientific.power(a, b);
                    expression = a + "^" + b;
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 2:
                    a = input.readDouble("Enter number: ");
                    result = scientific.square(a);
                    expression = a + "²";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 3:
                    a = input.readDouble("Enter number: ");
                    result = scientific.cube(a);
                    expression = a + "³";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 4:
                    a = input.readDouble("Enter number: ");
                    result = scientific.squareRoot(a);
                    expression = "√" + a;
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 5:
                    a = input.readDouble("Enter number: ");
                    result = scientific.cubeRoot(a);
                    expression = "∛" + a;
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 6:
                    a = input.readDouble("Enter number: ");
                    b = input.readDouble("Enter root degree: ");
                    result = scientific.nthRoot(a, b);
                    expression = b + "√" + a;
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 7:
                    a = input.readDouble("Enter number: ");
                    result = scientific.reciprocal(a);
                    expression = "1/" + a;
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 8:
                    n = input.readInt("Enter non-negative integer: ");
                    result = scientific.factorial(n);
                    expression = n + "!";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 9:
                    n = input.readInt("Enter n: ");
                    r = input.readInt("Enter r: ");
                    result = scientific.permutation(n, r);
                    expression = "P(" + n + "," + r + ")";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 10:
                    n = input.readInt("Enter n: ");
                    r = input.readInt("Enter r: ");
                    result = scientific.combination(n, r);
                    expression = "C(" + n + "," + r + ")";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 0:
                    // Return to main menu
                    break;
                default:
                    displayError("Invalid option selected.");
                    break;
            }
        } catch (ArithmeticException e) {
            displayError(e.getMessage());
        }
    }
    
    // ==================== Trigonometric Functions ====================
    
    private void trigonometricMenu() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│      TRIGONOMETRIC FUNCTIONS        │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│  1. Sine (radians)                  │");
        System.out.println("│  2. Cosine (radians)                │");
        System.out.println("│  3. Tangent (radians)               │");
        System.out.println("│  4. Sine (degrees)                  │");
        System.out.println("│  5. Cosine (degrees)                │");
        System.out.println("│  6. Tangent (degrees)               │");
        System.out.println("│  7. Arc Sine (asin)                 │");
        System.out.println("│  8. Arc Cosine (acos)               │");
        System.out.println("│  9. Arc Tangent (atan)              │");
        System.out.println("│ 10. Hyperbolic Sine (sinh)          │");
        System.out.println("│ 11. Hyperbolic Cosine (cosh)        │");
        System.out.println("│ 12. Hyperbolic Tangent (tanh)       │");
        System.out.println("│ 13. Degrees to Radians              │");
        System.out.println("│ 14. Radians to Degrees              │");
        System.out.println("│  0. Back to Main Menu               │");
        System.out.println("└─────────────────────────────────────┘");
        
        int choice = input.readMenuChoice("Enter your choice: ", 0, 14);
        
        try {
            double a, result;
            String expression;
            switch (choice) {
                case 1:
                    a = input.readDouble("Enter angle in radians: ");
                    result = scientific.sin(a);
                    expression = "sin(" + a + ")";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 2:
                    a = input.readDouble("Enter angle in radians: ");
                    result = scientific.cos(a);
                    expression = "cos(" + a + ")";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 3:
                    a = input.readDouble("Enter angle in radians: ");
                    result = scientific.tan(a);
                    expression = "tan(" + a + ")";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 4:
                    a = input.readDouble("Enter angle in degrees: ");
                    result = scientific.sinDeg(a);
                    expression = "sin(" + a + "°)";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 5:
                    a = input.readDouble("Enter angle in degrees: ");
                    result = scientific.cosDeg(a);
                    expression = "cos(" + a + "°)";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 6:
                    a = input.readDouble("Enter angle in degrees: ");
                    result = scientific.tanDeg(a);
                    expression = "tan(" + a + "°)";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 7:
                    a = input.readDouble("Enter value (-1 to 1): ");
                    result = scientific.asin(a);
                    expression = "asin(" + a + ")";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result + " radians");
                    break;
                case 8:
                    a = input.readDouble("Enter value (-1 to 1): ");
                    result = scientific.acos(a);
                    expression = "acos(" + a + ")";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result + " radians");
                    break;
                case 9:
                    a = input.readDouble("Enter value: ");
                    result = scientific.atan(a);
                    expression = "atan(" + a + ")";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result + " radians");
                    break;
                case 10:
                    a = input.readDouble("Enter value: ");
                    result = scientific.sinh(a);
                    expression = "sinh(" + a + ")";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 11:
                    a = input.readDouble("Enter value: ");
                    result = scientific.cosh(a);
                    expression = "cosh(" + a + ")";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 12:
                    a = input.readDouble("Enter value: ");
                    result = scientific.tanh(a);
                    expression = "tanh(" + a + ")";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 13:
                    a = input.readDouble("Enter degrees: ");
                    result = scientific.toRadians(a);
                    expression = a + "° → rad";
                    history.addEntry(expression, result);
                    displayResult(a + "° = " + result + " radians");
                    break;
                case 14:
                    a = input.readDouble("Enter radians: ");
                    result = scientific.toDegrees(a);
                    expression = a + " rad → °";
                    history.addEntry(expression, result);
                    displayResult(a + " radians = " + result + "°");
                    break;
                case 0:
                    // Return to main menu
                    break;
                default:
                    displayError("Invalid option selected.");
                    break;
            }
        } catch (ArithmeticException e) {
            displayError(e.getMessage());
        }
    }
    
    // ==================== Logarithmic Functions ====================
    
    private void logarithmicMenu() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│       LOGARITHMIC FUNCTIONS         │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│  1. Natural Logarithm (ln)          │");
        System.out.println("│  2. Common Logarithm (log₁₀)        │");
        System.out.println("│  3. Logarithm (custom base)         │");
        System.out.println("│  4. Exponential (e^x)               │");
        System.out.println("│  5. Power of 10 (10^x)              │");
        System.out.println("│  0. Back to Main Menu               │");
        System.out.println("└─────────────────────────────────────┘");
        
        int choice = input.readMenuChoice("Enter your choice: ", 0, 5);
        
        try {
            double a, b, result;
            String expression;
            switch (choice) {
                case 1:
                    a = input.readDouble("Enter positive number: ");
                    result = scientific.naturalLog(a);
                    expression = "ln(" + a + ")";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 2:
                    a = input.readDouble("Enter positive number: ");
                    result = scientific.log10(a);
                    expression = "log₁₀(" + a + ")";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 3:
                    a = input.readDouble("Enter positive number: ");
                    b = input.readDouble("Enter base: ");
                    result = scientific.logBase(a, b);
                    expression = "log" + b + "(" + a + ")";
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 4:
                    a = input.readDouble("Enter exponent: ");
                    result = scientific.exp(a);
                    expression = "e^" + a;
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 5:
                    a = input.readDouble("Enter exponent: ");
                    result = scientific.exp10(a);
                    expression = "10^" + a;
                    history.addEntry(expression, result);
                    displayResult(expression + " = " + result);
                    break;
                case 0:
                    // Return to main menu
                    break;
                default:
                    displayError("Invalid option selected.");
                    break;
            }
        } catch (ArithmeticException e) {
            displayError(e.getMessage());
        }
    }
    
    // ==================== Memory Operations ====================
    
    private void memoryMenu() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│        MEMORY OPERATIONS            │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│  1. Memory Store (MS)               │");
        System.out.println("│  2. Memory Recall (MR)              │");
        System.out.println("│  3. Memory Add (M+)                 │");
        System.out.println("│  4. Memory Subtract (M-)            │");
        System.out.println("│  5. Memory Clear (MC)               │");
        System.out.println("│  6. Show Last Result                │");
        System.out.println("│  0. Back to Main Menu               │");
        System.out.println("└─────────────────────────────────────┘");
        System.out.println("   Current Memory: " + calculator.getMemory());
        
        int choice = input.readMenuChoice("Enter your choice: ", 0, 6);
        
        double value;
        switch (choice) {
            case 1:
                value = input.readDouble("Enter value to store: ");
                calculator.memoryStore(value);
                displayResult("Stored " + value + " in memory.");
                break;
            case 2:
                displayResult("Memory value: " + calculator.memoryRecall());
                break;
            case 3:
                value = input.readDouble("Enter value to add: ");
                calculator.memoryAdd(value);
                displayResult("Added " + value + " to memory. New value: " + calculator.getMemory());
                break;
            case 4:
                value = input.readDouble("Enter value to subtract: ");
                calculator.memorySubtract(value);
                displayResult("Subtracted " + value + " from memory. New value: " + calculator.getMemory());
                break;
            case 5:
                calculator.memoryClear();
                displayResult("Memory cleared.");
                break;
            case 6:
                displayResult("Last result: " + calculator.getLastResult());
                break;
            case 0:
                // Return to main menu
                break;
            default:
                displayError("Invalid option selected.");
                break;
        }
    }
    
    // ==================== Constants ====================
    
    private void constantsMenu() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│          CONSTANTS                  │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│  1. Pi (π)                          │");
        System.out.println("│  2. Euler's Number (e)              │");
        System.out.println("│  0. Back to Main Menu               │");
        System.out.println("└─────────────────────────────────────┘");
        
        int choice = input.readMenuChoice("Enter your choice: ", 0, 2);
        
        switch (choice) {
            case 1:
                displayResult("π = " + scientific.getPi());
                break;
            case 2:
                displayResult("e = " + scientific.getE());
                break;
            case 0:
                // Return to main menu
                break;
            default:
                displayError("Invalid option selected.");
                break;
        }
    }
    
    // ==================== Calculation History ====================
    
    private void historyMenu() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│       CALCULATION HISTORY           │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│  1. View All History                │");
        System.out.println("│  2. View Last 10 Calculations       │");
        System.out.println("│  3. View Last Calculation           │");
        System.out.println("│  4. Use Result from History         │");
        System.out.println("│  5. Clear History                   │");
        System.out.println("│  0. Back to Main Menu               │");
        System.out.println("└─────────────────────────────────────┘");
        System.out.println("   Total entries: " + history.size());
        
        int choice = input.readMenuChoice("Enter your choice: ", 0, 5);
        
        switch (choice) {
            case 1:
                displayAllHistory();
                break;
            case 2:
                displayRecentHistory(10);
                break;
            case 3:
                displayLastCalculation();
                break;
            case 4:
                useHistoryResult();
                break;
            case 5:
                clearHistory();
                break;
            case 0:
                // Return to main menu
                break;
            default:
                displayError("Invalid option selected.");
                break;
        }
    }
    
    /**
     * Displays all calculation history.
     */
    private void displayAllHistory() {
        if (history.isEmpty()) {
            System.out.println("\n  📋 No calculations in history yet.");
            return;
        }
        
        System.out.println("\n┌─────────────────────────────────────────────────────┐");
        System.out.println("│              FULL CALCULATION HISTORY               │");
        System.out.println("├─────────────────────────────────────────────────────┤");
        
        List<HistoryEntry> entries = history.getHistory();
        for (int i = 0; i < entries.size(); i++) {
            System.out.printf("│  %3d. %-44s │%n", (i + 1), entries.get(i).toString());
        }
        
        System.out.println("└─────────────────────────────────────────────────────┘");
    }
    
    /**
     * Displays the last N calculations.
     * @param n Number of recent entries to display
     */
    private void displayRecentHistory(int n) {
        if (history.isEmpty()) {
            System.out.println("\n  📋 No calculations in history yet.");
            return;
        }
        
        List<HistoryEntry> entries = history.getLastEntries(n);
        int startIndex = Math.max(0, history.size() - n);
        
        System.out.println("\n┌─────────────────────────────────────────────────────┐");
        System.out.printf("│           LAST %d CALCULATIONS                       │%n", entries.size());
        System.out.println("├─────────────────────────────────────────────────────┤");
        
        for (int i = 0; i < entries.size(); i++) {
            System.out.printf("│  %3d. %-44s │%n", (startIndex + i + 1), entries.get(i).toString());
        }
        
        System.out.println("└─────────────────────────────────────────────────────┘");
    }
    
    /**
     * Displays the most recent calculation.
     */
    private void displayLastCalculation() {
        HistoryEntry last = history.getLastEntry();
        if (last == null) {
            System.out.println("\n  📋 No calculations in history yet.");
            return;
        }
        
        System.out.println("\n  📊 Last Calculation: " + last.toString());
    }
    
    /**
     * Allows user to store a history result in memory.
     */
    private void useHistoryResult() {
        if (history.isEmpty()) {
            System.out.println("\n  📋 No calculations in history yet.");
            return;
        }
        
        displayAllHistory();
        
        int index = input.readInt("\nEnter calculation number to use (1-" + history.size() + "): ");
        
        if (index < 1 || index > history.size()) {
            displayError("Invalid selection.");
            return;
        }
        
        HistoryEntry entry = history.getEntry(index - 1);
        if (entry != null) {
            calculator.memoryStore(entry.getResult());
            displayResult("Stored " + entry.getResult() + " in memory from: " + entry.getExpression());
        }
    }
    
    /**
     * Clears all calculation history.
     */
    private void clearHistory() {
        if (history.isEmpty()) {
            System.out.println("\n  📋 History is already empty.");
            return;
        }
        
        if (input.readYesNo("Are you sure you want to clear all history?")) {
            history.clear();
            displayResult("History cleared successfully.");
        } else {
            System.out.println("\n  Operation cancelled.");
        }
    }
    
    // ==================== Display Helpers ====================
    
    private void displayResult(String message) {
        System.out.println("\n  ✓ RESULT: " + message);
    }
    
    private void displayError(String message) {
        System.out.println("\n  ✗ ERROR: " + message);
    }
}
