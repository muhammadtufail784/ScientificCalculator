@echo off
REM Scientific Calculator - Compilation Script (Windows)
REM This script compiles and runs the Scientific Calculator

echo ╔═══════════════════════════════════════════════════════════╗
echo ║         Scientific Calculator - Build Script              ║
echo ╚═══════════════════════════════════════════════════════════╝
echo.

REM Set directories
set SRC_DIR=src\main\java
set OUT_DIR=out

REM Clean and create output directory
echo → Cleaning output directory...
if exist "%OUT_DIR%" rmdir /s /q "%OUT_DIR%"
mkdir "%OUT_DIR%"

REM Compile Java files
echo → Compiling Java files...
javac -d "%OUT_DIR%" ^
    "%SRC_DIR%\com\calculator\Main.java" ^
    "%SRC_DIR%\com\calculator\core\Calculator.java" ^
    "%SRC_DIR%\com\calculator\core\ScientificOperations.java" ^
    "%SRC_DIR%\com\calculator\core\Constants.java" ^
    "%SRC_DIR%\com\calculator\ui\ConsoleUI.java" ^
    "%SRC_DIR%\com\calculator\util\InputHandler.java" ^
    "%SRC_DIR%\com\calculator\util\CalculationHistory.java" ^
    "%SRC_DIR%\com\calculator\util\NumberFormatter.java"

REM Check if compilation was successful
if %ERRORLEVEL% EQU 0 (
    echo ✓ Compilation successful!
    echo.
    echo → Starting Scientific Calculator...
    echo ─────────────────────────────────────────────────────────────
    echo.
    java -cp "%OUT_DIR%" com.calculator.Main
) else (
    echo ✗ Compilation failed. Please check for errors.
    exit /b 1
)

