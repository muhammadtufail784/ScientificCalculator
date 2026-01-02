#!/bin/bash

# Scientific Calculator - Compilation Script (Unix/Mac)
# This script compiles and runs the Scientific Calculator

echo "╔═══════════════════════════════════════════════════════════╗"
echo "║         Scientific Calculator - Build Script              ║"
echo "╚═══════════════════════════════════════════════════════════╝"
echo ""

# Set directories
SRC_DIR="src/main/java"
OUT_DIR="out"

# Clean and create output directory
echo "→ Cleaning output directory..."
rm -rf "$OUT_DIR"
mkdir -p "$OUT_DIR"

# Compile Java files
echo "→ Compiling Java files..."
javac -d "$OUT_DIR" \
    "$SRC_DIR/com/calculator/Main.java" \
    "$SRC_DIR/com/calculator/core/Calculator.java" \
    "$SRC_DIR/com/calculator/core/ScientificOperations.java" \
    "$SRC_DIR/com/calculator/core/Constants.java" \
    "$SRC_DIR/com/calculator/ui/ConsoleUI.java" \
    "$SRC_DIR/com/calculator/util/InputHandler.java" \
    "$SRC_DIR/com/calculator/util/CalculationHistory.java" \
    "$SRC_DIR/com/calculator/util/NumberFormatter.java"

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "✓ Compilation successful!"
    echo ""
    echo "→ Starting Scientific Calculator..."
    echo "─────────────────────────────────────────────────────────────"
    echo ""
    java -cp "$OUT_DIR" com.calculator.Main
else
    echo "✗ Compilation failed. Please check for errors."
    exit 1
fi

