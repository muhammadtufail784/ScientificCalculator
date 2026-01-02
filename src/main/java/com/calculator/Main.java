package com.calculator;

import com.calculator.core.Constants;
import com.calculator.ui.ConsoleUI;

/**
 * Scientific Calculator Application
 * Entry point for the console-based scientific calculator.
 * 
 * JAVA BEST PRACTICES DEMONSTRATED IN THIS PROJECT:
 * 
 * 1. PACKAGE ORGANIZATION:
 *    - com.calculator.core    → Business logic (Calculator, ScientificOperations)
 *    - com.calculator.ui      → User interface (ConsoleUI)
 *    - com.calculator.util    → Utilities (InputHandler, CalculationHistory)
 * 
 * 2. NAMING CONVENTIONS:
 *    - Classes: PascalCase (Calculator, ScientificOperations)
 *    - Methods: camelCase (add, squareRoot, displayResult)
 *    - Constants: UPPER_SNAKE_CASE (MAX_FACTORIAL_INPUT, PI)
 *    - Variables: camelCase (lastResult, running)
 * 
 * 3. SOLID PRINCIPLES:
 *    - Single Responsibility: Each class has one purpose
 *    - Open/Closed: Easy to extend with new operations
 * 
 * 4. ERROR HANDLING:
 *    - Input validation before processing
 *    - Descriptive exception messages
 *    - Try-catch blocks in UI layer
 * 
 * 5. DOCUMENTATION:
 *    - Javadoc comments on all public methods
 *    - Inline comments for complex logic
 * 
 * @author Yahya
 * @version 1.0
 * @since Java 8
 */
public class Main {
    
    /**
     * Application entry point.
     * Displays welcome banner and starts the calculator.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Display welcome banner
        printWelcomeBanner();
        
        // Create and start the calculator UI
        ConsoleUI calculator = new ConsoleUI();
        calculator.start();
    }
    
    /**
     * Prints the welcome banner to the console.
     * 
     * BEGINNER TIP: Separating this into its own method makes
     * the main() method cleaner and easier to read.
     */
    private static void printWelcomeBanner() {
        System.out.println("╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║         " + Constants.APP_NAME.toUpperCase() + " v" + Constants.APP_VERSION + "                        ║");
        System.out.println("║         Console-Based Application                         ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("  Features:");
        System.out.println("  • Basic Arithmetic (+, -, ×, ÷, %)");
        System.out.println("  • Scientific Functions (powers, roots, factorial)");
        System.out.println("  • Trigonometric Functions (sin, cos, tan)");
        System.out.println("  • Logarithmic Functions (ln, log)");
        System.out.println("  • Memory Operations (MS, MR, M+, M-, MC)");
        System.out.println("  • Calculation History");
        System.out.println();
    }
}
