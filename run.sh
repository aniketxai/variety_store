#!/usr/bin/env bash
# Variety Store Inventory & POS System Execution Launcher
set -e

if [ -z "$JAVA_HOME" ]; then
    if [ -d "/Library/Java/JavaVirtualMachines/jdk-26.jdk/Contents/Home" ]; then
        export JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk-26.jdk/Contents/Home"
    elif [ -d "/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home" ]; then
        export JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home"
    fi
fi

JAVA_CMD="java"
if [ -n "$JAVA_HOME" ]; then
    JAVA_CMD="$JAVA_HOME/bin/java"
fi

if [ ! -d "target/classes" ]; then
    echo "[Info] Target build directory missing. Running ./build.sh first..."
    bash build.sh
fi

ARG="${1:---cli-batch}"

if [ "$ARG" = "--test" ] || [ "$ARG" = "-t" ]; then
    echo "[Run] Executing Automated Unit Test Suite..."
    "$JAVA_CMD" -cp "lib/*:target/classes:target/test-classes" inventorysoftware.TestRunner
elif [ "$ARG" = "--help" ] || [ "$ARG" = "-h" ]; then
    echo "Usage: ./run.sh [OPTION]"
    echo "Options:"
    echo "  --cli-batch, --headless    Run in non-interactive terminal batch mode (default)"
    echo "  --cli, -c                  Launch interactive command-line terminal interface"
    echo "  --gui, -g                  Launch Swing GUI application interface"
    echo "  --test, -t                 Execute automated unit test suite"
    echo "  --help, -h                 Show this help menu"
else
    echo "[Run] Launching Variety Store Application ($ARG)..."
    "$JAVA_CMD" -cp "lib/*:target/classes" inventorysoftware.Main "$@"
fi
