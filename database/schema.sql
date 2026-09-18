-- Variety Store Inventory & POS System Database Schema Initialization

CREATE TABLE IF NOT EXISTS USERS (
    fname VARCHAR(100),
    lname VARCHAR(100),
    password VARCHAR(100),
    email VARCHAR(150) PRIMARY KEY,
    contact VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS SELLER (
    s_id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(150),
    company VARCHAR(150),
    address VARCHAR(255),
    product_type VARCHAR(100),
    email VARCHAR(150),
    contact1 VARCHAR(20),
    contact2 VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS CUSTOMER (
    c_id VARCHAR(50) PRIMARY KEY,
    c_name VARCHAR(150),
    c_address VARCHAR(255),
    c_email VARCHAR(150),
    contact VARCHAR(20),
    gender VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS PRODUCT (
    p_id VARCHAR(50) PRIMARY KEY,
    p_name VARCHAR(150),
    p_type VARCHAR(100),
    p_detail VARCHAR(255),
    buying DOUBLE,
    selling DOUBLE,
    quantity INT,
    date VARCHAR(50),
    s_id VARCHAR(50),
    FOREIGN KEY (s_id) REFERENCES SELLER(s_id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS BILLING (
    id VARCHAR(50),
    date VARCHAR(50),
    time VARCHAR(50),
    c_id VARCHAR(50),
    p_id VARCHAR(50),
    name VARCHAR(150),
    price DOUBLE,
    quantity INT,
    total DOUBLE,
    total_amount DOUBLE,
    discount DOUBLE,
    d_amount DOUBLE,
    paid DOUBLE,
    returrn DOUBLE
);

-- Seed Default Admin Account if missing
MERGE INTO USERS (fname, lname, password, email, contact) KEY (email)
VALUES ('Admin', 'User', 'admin123', 'admin@varietystore.com', '9876543210');

-- Seed Sample Seller/Supplier
MERGE INTO SELLER (s_id, name, company, address, product_type, email, contact1, contact2) KEY (s_id)
VALUES ('SEL-101', 'Apex Wholesale', 'Apex Enterprises', '123 Supply Ave, City', 'Electronics', 'apex@suppliers.com', '9876500001', '9876500002');

-- Seed Sample Customer
MERGE INTO CUSTOMER (c_id, c_name, c_address, c_email, contact, gender) KEY (c_id)
VALUES ('CUS-101', 'John Doe', '456 Elm Street', 'john.doe@example.com', '9123456789', 'Male');

-- Seed Sample Products
MERGE INTO PRODUCT (p_id, p_name, p_type, p_detail, buying, selling, quantity, date, s_id) KEY (p_id)
VALUES ('PRO-101', 'Wireless Mouse', 'Electronics', 'Ergonomic 2.4GHz Optical Mouse', 15.00, 25.00, 50, '18-09-2026', 'SEL-101');

MERGE INTO PRODUCT (p_id, p_name, p_type, p_detail, buying, selling, quantity, date, s_id) KEY (p_id)
VALUES ('PRO-102', 'USB-C Cable 2m', 'Electronics', 'Fast Charging Nylon Braided Cable', 5.00, 12.00, 100, '18-09-2026', 'SEL-101');
