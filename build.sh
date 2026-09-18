#!/usr/bin/env bash
# Variety Store Inventory & POS System Build Script
set -e

echo "================================================="
echo "  Building Variety Store Inventory System...     "
echo "================================================="

# Locate JDK if JAVA_HOME is not set
if [ -z "$JAVA_HOME" ]; then
    if [ -d "/Library/Java/JavaVirtualMachines/jdk-26.jdk/Contents/Home" ]; then
        export JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk-26.jdk/Contents/Home"
    elif [ -d "/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home" ]; then
        export JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home"
    fi
fi

JAVAC_CMD="javac"
JAVA_CMD="java"
JAR_CMD="jar"

if [ -n "$JAVA_HOME" ]; then
    JAVAC_CMD="$JAVA_HOME/bin/javac"
    JAVA_CMD="$JAVA_HOME/bin/java"
    JAR_CMD="$JAVA_HOME/bin/jar"
fi

echo "[Build] Using Java compiler: $($JAVAC_CMD -version 2>&1)"

mkdir -p target/classes
mkdir -p target/test-classes

echo "[Build] Compiling main application source code..."
find src/main/java -name "*.java" -print0 | xargs -0 "$JAVAC_CMD" -cp "lib/*:src/main/resources" -d target/classes

echo "[Build] Copying resource files..."
cp -r src/main/resources/* target/classes/ 2>/dev/null || true

echo "[Build] Compiling unit test suite..."
find src/test/java -name "*.java" -print0 | xargs -0 "$JAVAC_CMD" -cp "lib/*:target/classes" -d target/test-classes

echo "[Build] Creating executable JAR target/variety-store-inventory-1.0.0.jar..."
"$JAR_CMD" cfe target/variety-store-inventory-1.0.0.jar inventorysoftware.Main -C target/classes .

echo "================================================="
echo "   BUILD SUCCESSFUL! Target artifact created:    "
echo "   target/variety-store-inventory-1.0.0.jar      "
echo "================================================="
