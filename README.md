# Scientific Calculator

A console-based Scientific Calculator application built in Java 8+.

## Project Structure

```
ScientificCalculator/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── calculator/
│                   ├── Main.java                     # Application entry point
│                   ├── core/
│                   │   ├── Calculator.java           # Basic arithmetic operations
│                   │   ├── ScientificOperations.java # Advanced math functions
│                   │   └── Constants.java            # Mathematical constants
│                   ├── ui/
│                   │   └── ConsoleUI.java            # Console user interface
│                   └── util/
│                       ├── InputHandler.java         # Input validation
│                       ├── CalculationHistory.java   # History tracking
│                       └── NumberFormatter.java      # Number formatting
├── compile.sh         # Unix/Mac compilation script
├── compile.bat        # Windows compilation script
└── README.md          # This file
```

## Features

### Basic Arithmetic
- Addition, Subtraction, Multiplication, Division
- Modulus, Absolute Value, Negation

### Scientific Functions
- Power (x^y), Square (x²), Cube (x³)
- Square Root (√x), Cube Root (∛x), Nth Root
- Reciprocal (1/x)
- Factorial (n!), Permutation P(n,r), Combination C(n,r)

### Trigonometric Functions
- Sine, Cosine, Tangent (radians & degrees)
- Inverse: Arc Sine, Arc Cosine, Arc Tangent
- Hyperbolic: sinh, cosh, tanh
- Angle Conversions: Degrees ↔ Radians

### Logarithmic Functions
- Natural Logarithm (ln)
- Common Logarithm (log₁₀)
- Custom Base Logarithm
- Exponential (e^x, 10^x)

### Memory Operations
- Memory Store (MS), Memory Recall (MR)
- Memory Add (M+), Memory Subtract (M-)
- Memory Clear (MC)

### Calculation History
- View all history
- View recent calculations
- Use results from history
- Clear history

### Constants
- Pi (π) = 3.14159265358979...
- Euler's Number (e) = 2.71828182845904...
- Golden Ratio (φ) = 1.61803398874989...

## Requirements

- Java 8 or higher (JDK)

## How to Compile

### Option 1: Using the provided scripts

**On Mac/Linux:**
```bash
cd ScientificCalculator
chmod +x compile.sh
./compile.sh
```

**On Windows:**
```cmd
cd ScientificCalculator
compile.bat
```

### Option 2: Manual compilation

```bash
# Navigate to project directory
cd ScientificCalculator

# Create output directory
mkdir -p out

# Compile all Java files
javac -d out src/main/java/com/calculator/*.java \
             src/main/java/com/calculator/core/*.java \
             src/main/java/com/calculator/ui/*.java \
             src/main/java/com/calculator/util/*.java

# Run the application
java -cp out com.calculator.Main
```

## How to Run

After compilation:
```bash
java -cp out com.calculator.Main
```

## Usage Example

```
╔═══════════════════════════════════════════════════════════╗
║         SCIENTIFIC CALCULATOR v1.0                        ║
║         Console-Based Application                         ║
╚═══════════════════════════════════════════════════════════╝

  Features:
  • Basic Arithmetic (+, -, ×, ÷, %)
  • Scientific Functions (powers, roots, factorial)
  • Trigonometric Functions (sin, cos, tan)
  • Logarithmic Functions (ln, log)
  • Memory Operations (MS, MR, M+, M-, MC)
  • Calculation History

┌─────────────────────────────────────┐
│           MAIN MENU                 │
├─────────────────────────────────────┤
│  1. Basic Arithmetic                │
│  2. Scientific Functions            │
│  3. Trigonometric Functions         │
│  4. Logarithmic Functions           │
│  5. Memory Operations               │
│  6. Constants                       │
│  7. Calculation History             │
│  0. Exit                            │
└─────────────────────────────────────┘
Enter your choice: 
```

## Java Best Practices Applied

### 1. Naming Conventions
| Type | Convention | Example |
|------|------------|---------|
| Classes | PascalCase | `Calculator`, `ScientificOperations` |
| Methods | camelCase | `add()`, `squareRoot()` |
| Variables | camelCase | `lastResult`, `running` |
| Constants | UPPER_SNAKE_CASE | `MAX_FACTORIAL_INPUT`, `PI` |

### 2. Package Organization
```
com.calculator.core  → Business logic
com.calculator.ui    → User interface
com.calculator.util  → Utilities
```

### 3. SOLID Principles
- **Single Responsibility**: Each class has one specific purpose
- **Open/Closed**: Easy to extend with new operations
- **Liskov Substitution**: Consistent interfaces
- **Interface Segregation**: Focused method signatures
- **Dependency Inversion**: UI depends on abstractions

### 4. Clean Code Practices
- **Meaningful Names**: Variables and methods describe their purpose
- **Small Methods**: Each method does one thing
- **DRY (Don't Repeat Yourself)**: Reusable utility methods
- **Comments**: Javadoc for public APIs, inline for complex logic
- **Error Handling**: Descriptive exceptions with try-catch

### 5. Defensive Programming
- Input validation before processing
- Default cases in switch statements
- Null checks where appropriate
- Bounds checking for arrays/collections

## Class Descriptions

| Class | Purpose |
|-------|---------|
| `Main` | Application entry point |
| `Calculator` | Basic arithmetic operations with memory |
| `ScientificOperations` | Advanced mathematical functions |
| `Constants` | Mathematical and application constants |
| `ConsoleUI` | User interface and menu system |
| `InputHandler` | Input reading and validation |
| `CalculationHistory` | Stores calculation history |
| `NumberFormatter` | Formats numbers for display |

## Error Handling

The calculator handles various error conditions:

| Error | Handling |
|-------|----------|
| Invalid input | Re-prompts user until valid |
| Division by zero | Displays error message |
| Negative square root | Displays error message |
| Invalid logarithm | Displays error message |
| Factorial overflow | Limits input to 170 |
| Invalid menu choice | Re-prompts within valid range |

## Author

Yahya

## License

This project is for educational purposes.
# ScientificCalculator
