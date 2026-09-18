# Variety Store Inventory & Point of Sale (POS) Management System

A robust, enterprise-grade Java application designed for retail variety stores to streamline inventory management, supplier relations, customer tracking, point-of-sale (POS) billing, and PDF receipt generation.

---

## Project Overview
The **Variety Store Inventory & POS System** is a modular Java desktop and command-line application built with an embedded H2 database. It enables retail store managers and cashiers to efficiently manage product catalogs, monitor inventory levels with automated low-stock warnings, manage supplier networks, process sales transactions, and generate PDF invoices.

Designed to adhere to academic and technical evaluation standards, the application provides **dual-mode execution**: it runs seamlessly via a Command-Line Interface (CLI) in headless terminal environments or via a rich Java Swing Graphical User Interface (GUI).

---

## Key Features

### 1. Inventory & Product Management
- Complete CRUD operations for store products.
- Real-time stock tracking with buying vs. selling price analysis.
- Automatic low-stock alert monitoring.

### 2. Point of Sale (POS) & Billing
- Fast line-item billing and cart calculation.
- Automated discount calculation and change return computation.
- Automated PDF invoice receipt generation using iText PDF engine.

### 3. Supplier & Customer Management
- Maintain detailed records for product suppliers (sellers) and company contacts.
- Track customer profiles, contact numbers, and purchasing activity.

### 4. Dual Execution Modes & Zero-Setup Database
- **CLI Mode**: Interactive terminal navigation and non-interactive batch mode (`--cli-batch`).
- **GUI Mode**: Rich desktop visual interface built with Java Swing.
- **Embedded Database**: H2 database with automatic schema initialization and pre-seeded sample data.

### 5. Automated Unit Test Suite
- Comprehensive unit tests verifying authentication, validation, inventory decrementing, and billing math.

---

## Technologies & Tools Used
- **Programming Language**: Java 17 / Java 26 (JDK SE)
- **Database Engine**: Embedded H2 Database (v1.4.200)
- **PDF Export Engine**: iText PDF Library (v5.4.0)
- **GUI Framework**: Java Swing & AWT (JTattoo, RS Components)
- **Build System**: Apache Maven & Cross-Platform Shell Scripts (`build.sh`, `run.sh`)
- **Testing Framework**: JUnit 5 / Built-in Automated Test Runner

---

## Project Directory Structure

```
variety_store/
├── pom.xml                        # Maven project descriptor
├── build.sh                       # One-click shell build script
├── run.sh                         # Command-line application launcher
├── statement.md                   # Problem statement & project scope
├── README.md                      # Setup & user documentation
├── Project_Report.pdf             # 15-Section formal PDF project report
├── Project_Report.md              # Markdown source of project report
├── .gitignore                     # Version control ignore definitions
├── database/                      # H2 embedded database storage
│   ├── includedata.mv.db          # Embedded database data file
│   └── schema.sql                 # Database SQL DDL schema & seed data
├── lib/                           # Standalone JAR dependency libraries
│   ├── h2-1.4.200.jar
│   ├── itextpdf-5.4.0.jar
│   └── ... (UI component libraries)
└── src/
    ├── main/
    │   ├── java/inventorysoftware/
    │   │   ├── Main.java          # Unified application entry point
    │   │   ├── model/             # Domain entities (User, Product, Seller, Customer, BillingItem)
    │   │   ├── dao/               # Data Access Objects & DatabaseManager
    │   │   ├── service/           # Business logic (Auth, Inventory, Billing, Validation)
    │   │   ├── cli/               # Command Line Interface (CLIController)
    │   │   └── gui/               # Swing GUI screens (Home, NewSignin, SplashScreen)
    │   └── resources/             # Application icons & graphics assets
    └── test/
        └── java/inventorysoftware/# Automated Unit Test Suite
```

---

## Installation & Execution Instructions

### Prerequisites
- Java Development Kit (JDK 17 or higher installed).

---

### Option 1: Quick Shell Execution (Recommended)

1. **Build the Application**:
   ```bash
   ./build.sh
   ```

2. **Run in Command-Line Batch Mode (Non-Interactive / Headless Evaluation)**:
   ```bash
   ./run.sh --cli-batch
   ```

3. **Run in Interactive CLI Terminal Mode**:
   ```bash
   ./run.sh --cli
   ```

4. **Run in GUI Mode (Requires Desktop Display)**:
   ```bash
   ./run.sh --gui
   ```

5. **Run Automated Unit Test Suite**:
   ```bash
   ./run.sh --test
   ```

---

### Option 2: Maven Execution

1. **Compile & Package**:
   ```bash
   mvn clean package
   ```

2. **Execute Application JAR**:
   ```bash
   java -jar target/variety-store-inventory-1.0.0.jar --cli-batch
   ```

---

## Testing Approach & Instructions

The project contains a comprehensive automated unit test suite.

To run the unit tests directly:
```bash
./run.sh --test
```

### Tested Scenarios:
- **ValidationUtilsTest**: Validates email formats, phone numbers, and numeric range limits.
- **AuthServiceTest**: Validates credential authentication, password matching, and user registration.
- **InventoryServiceTest**: Validates product fetching, stock decrements, and stockout exception protection.
- **BillingServiceTest**: Validates line-item calculations, percentage discount application, and change return logic.

---

## Architecture & Workflow Overview

```
                      +-----------------------------+
                      |   Main Application Launcher |
                      |    (inventorysoftware.Main) |
                      +--------------+--------------+
                                     |
              +----------------------+----------------------+
              |                                             |
              v                                             v
   +--------------------+                        +--------------------+
   |  CLI Controller    |                        |    Swing GUI       |
   | (Interactive/Batch)|                        |   Presentation     |
   +----------+---------+                        +----------+---------+
              |                                             |
              +----------------------+----------------------+
                                     |
                                     v
                        +--------------------------+
                        |      Service Layer       |
                        | (Auth, Inventory, POS)   |
                        +------------+-------------+
                                     |
                                     v
                        +--------------------------+
                        |      DAO / Data Layer    |
                        |    (H2 Database Access)  |
                        +------------+-------------+
                                     |
                                     v
                        +--------------------------+
                        |   Embedded H2 Database   |
                        | (./database/includedata) |
                        +--------------------------+
```

---

## License & Academic Integrity
Submitted as an original project for Java Programming Course Evaluation.
