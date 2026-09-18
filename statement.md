# Project Statement - Variety Store Inventory & POS System

## 1. Problem Statement
Retail variety stores and SMB merchants face significant challenges managing multi-category inventory, supplier records, customer accounts, point-of-sale (POS) billing, and sales analytics. Traditional paper-based ledger systems or fragmented manual record-keeping lead to stockout errors, inaccurate financial reporting, mismanaged supplier contracts, delayed customer checkout, and overall operational inefficiency. 

The **Variety Store Inventory & Point of Sale (POS) Management System** addresses this problem by delivering a unified, desktop and terminal-accessible Java software application backed by an embedded database. It automates inventory tracking, simplifies sales billing with discount calculations and PDF receipt generation, monitors stock thresholds, and manages customer/supplier relationships.

---

## 2. Scope of the Project
The scope of this project encompasses an end-to-end retail management software suite tailored for variety store operations:
- **Authentication & User Role Management**: Secure access control for store managers and staff members.
- **Inventory & Product Management**: Real-time product cataloging, stock adjustment, buying/selling price tracking, and automated low-stock warnings.
- **Supplier (Seller) Management**: Comprehensive directory of suppliers, product category mapping, and contact details.
- **Customer Relationship Management**: Database of registered store customers, purchase histories, and contact records.
- **Point of Sale (POS) & Billing Module**: Rapid item checkout, line-item subtotaling, configurable discount rates, cash return calculation, and automated PDF receipt generation via iText.
- **Dual Execution Interface**: Full support for both interactive/automated Command-Line Interface (CLI) and graphical Swing User Interface (GUI), ensuring zero-dependency execution across any terminal or desktop environment.

---

## 3. Target Users
1. **Store Owners & Managers**: Oversee full store inventory, review low-stock alerts, analyze sales performance, and manage supplier relations.
2. **Sales Cashiers & Staff Members**: Process customer transactions quickly at POS counters, apply discounts, issue receipts, and register customer details.
3. **Inventory Supervisors**: Update stock levels, add new product inventory items, and record supplier deliveries.

---

## 4. High-Level Features
- **Real-Time Stock Tracking**: Automated calculation of stock levels with threshold-based low stock alerts.
- **Instant POS Checkout**: Flexible line-item billing with automated discount and change return calculations.
- **PDF Receipt Generation**: Export professional PDF receipts directly upon billing completion.
- **Embedded Database Storage**: Built-in zero-configuration H2 database with automatic schema creation and data persistence.
- **Dual CLI & GUI Modes**: Universal compatibility allowing headless terminal execution or desktop GUI visualization.
- **Comprehensive Unit Test Suite**: Built-in test suite ensuring reliability, validation integrity, and robustness.
