package com.calculator.util;

import java.util.Scanner;

/**
 * InputHandler class for managing user input.
 * Provides methods for reading and validating different types of input.
 */
public class InputHandler {
    
    private final Scanner scanner;
    
    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Reads a double value from user input.
     * @param prompt Message to display to user
     * @return The double value entered
     */
    public double readDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // Clear invalid input
            System.out.print(prompt);
        }
        return scanner.nextDouble();
    }
    
    /**
     * Reads an integer value from user input.
     * @param prompt Message to display to user
     * @return The integer value entered
     */
    public int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next(); // Clear invalid input
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }
    
    /**
     * Reads a string value from user input.
     * @param prompt Message to display to user
     * @return The string entered
     */
    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.next().trim();
    }
    
    /**
     * Reads a line of text from user input.
     * @param prompt Message to display to user
     * @return The line entered
     */
    public String readLine(String prompt) {
        System.out.print(prompt);
        scanner.nextLine(); // Clear buffer
        return scanner.nextLine().trim();
    }
    
    /**
     * Reads a menu choice (integer) within a valid range.
     * @param prompt Message to display
     * @param min Minimum valid choice
     * @param max Maximum valid choice
     * @return Valid menu choice
     */
    public int readMenuChoice(String prompt, int min, int max) {
        int choice;
        while (true) {
            choice = readInt(prompt);
            if (choice >= min && choice <= max) {
                return choice;
            }
            System.out.println("Invalid choice. Please enter a number between " + min + " and " + max + ".");
        }
    }
    
    /**
     * Reads a yes/no confirmation from user.
     * @param prompt Message to display
     * @return true for yes, false for no
     */
    public boolean readYesNo(String prompt) {
        System.out.print(prompt + " (y/n): ");
        String input = scanner.next().trim().toLowerCase();
        return input.equals("y") || input.equals("yes");
    }
    
    /**
     * Closes the scanner resource.
     */
    public void close() {
        scanner.close();
    }
    
    /**
     * Clears the input buffer.
     */
    public void clearBuffer() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}

