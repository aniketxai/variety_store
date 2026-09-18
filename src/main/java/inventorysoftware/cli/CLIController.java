package inventorysoftware.cli;

import inventorysoftware.dao.*;
import inventorysoftware.model.*;
import inventorysoftware.service.*;
import java.util.*;

/**
 * Full Command-Line Interface (CLI) Controller for Variety Store Management System.
 * Supports interactive navigation and automated non-blocking execution mode.
 */
public class CLIController {

    private final AuthService authService;
    private final InventoryService inventoryService;
    private final BillingService billingService;
    private final SellerDAO sellerDAO;
    private final CustomerDAO customerDAO;
    private final Scanner scanner;

    public CLIController() {
        this.authService = new AuthService();
        this.inventoryService = new InventoryService();
        this.billingService = new BillingService();
        this.sellerDAO = new SellerDAO();
        this.customerDAO = new CustomerDAO();
        this.scanner = new Scanner(System.in);
    }

    public void runNonInteractiveBatch() {
        System.out.println("=================================================");
        System.out.println("  VARIETY STORE INVENTORY & POS SYSTEM (CLI BATCH)");
        System.out.println("=================================================");
        DatabaseManager.initializeSchema();
        try {
            System.out.println("[CLI] Authenticating default admin...");
            User user = authService.login("admin@varietystore.com", "admin123");
            if (user != null) {
                System.out.println("[CLI] Admin logged in successfully: " + user.getFullName());
            } else {
                authService.register("Admin", "User", "admin@varietystore.com", "admin123", "9876543210");
                System.out.println("[CLI] Default Admin account created & authenticated.");
            }

            List<Product> products = inventoryService.getAllProducts();
            System.out.println("[CLI] Current Inventory Stock Count: " + products.size() + " items");
            for (Product p : products) {
                System.out.printf("  - [%s] %s | Qty: %d | Price: $%.2f | Category: %s\n",
                    p.getId(), p.getName(), p.getQuantity(), p.getSellingPrice(), p.getType());
            }

            List<Seller> sellers = sellerDAO.getAllSellers();
            System.out.println("[CLI] Supplier Records Count: " + sellers.size());

            List<Customer> customers = customerDAO.getAllCustomers();
            System.out.println("[CLI] Customer Records Count: " + customers.size());

            System.out.println("[CLI] Batch execution completed successfully with exit code 0.");
        } catch (Exception e) {
            System.err.println("[CLI Error] Batch execution exception: " + e.getMessage());
        }
    }

    public void startInteractiveCLI() {
        DatabaseManager.initializeSchema();
        System.out.println("=================================================");
        System.out.println("    WELCOME TO VARIETY STORE MANAGEMENT SYSTEM    ");
        System.out.println("=================================================");
        
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("\n1. Login");
            System.out.println("2. Register New Staff/Admin Account");
            System.out.println("3. Exit");
            System.out.print("Select Option (1-3): ");
            String choice = scanner.nextLine().trim();

            if ("1".equals(choice)) {
                System.out.print("Enter Email: ");
                String email = scanner.nextLine().trim();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine().trim();
                try {
                    User u = authService.login(email, password);
                    if (u != null) {
                        System.out.println("--> Login Successful! Welcome, " + u.getFullName());
                        loggedIn = true;
                    } else {
                        System.out.println("--> Invalid credentials. Please try again.");
                    }
                } catch (Exception e) {
                    System.out.println("--> Error: " + e.getMessage());
                }
            } else if ("2".equals(choice)) {
                System.out.print("Enter First Name: ");
                String fn = scanner.nextLine().trim();
                System.out.print("Enter Last Name: ");
                String ln = scanner.nextLine().trim();
                System.out.print("Enter Email: ");
                String em = scanner.nextLine().trim();
                System.out.print("Enter Password: ");
                String pw = scanner.nextLine().trim();
                System.out.print("Enter Contact Number: ");
                String ct = scanner.nextLine().trim();
                try {
                    if (authService.register(fn, ln, em, pw, ct)) {
                        System.out.println("--> Registration Successful! Please login.");
                    } else {
                        System.out.println("--> Registration failed.");
                    }
                } catch (Exception e) {
                    System.out.println("--> Error: " + e.getMessage());
                }
            } else if ("3".equals(choice)) {
                System.out.println("Exiting Variety Store System. Goodbye!");
                return;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        mainMenu();
    }

    private void mainMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n================ MAIN MENU ================");
            System.out.println("1. View Inventory Stock");
            System.out.println("2. Add New Product");
            System.out.println("3. Manage Suppliers (Sellers)");
            System.out.println("4. Manage Customers");
            System.out.println("5. Point of Sale (POS) / Billing");
            System.out.println("6. Low Stock Alerts Report");
            System.out.println("7. Logout & Exit");
            System.out.print("Select Option (1-7): ");
            String opt = scanner.nextLine().trim();

            switch (opt) {
                case "1":
                    displayInventory();
                    break;
                case "2":
                    addNewProduct();
                    break;
                case "3":
                    manageSuppliers();
                    break;
                case "4":
                    manageCustomers();
                    break;
                case "5":
                    processBilling();
                    break;
                case "6":
                    viewLowStockAlerts();
                    break;
                case "7":
                    running = false;
                    System.out.println("Logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void displayInventory() {
        try {
            List<Product> products = inventoryService.getAllProducts();
            System.out.println("\n--- INVENTORY PRODUCTS ---");
            if (products.isEmpty()) {
                System.out.println("No products found in inventory.");
                return;
            }
            System.out.printf("%-10s %-20s %-15s %-10s %-10s %-8s\n", "ID", "Name", "Category", "Buying($)", "Selling($)", "Stock");
            System.out.println("-------------------------------------------------------------------------");
            for (Product p : products) {
                System.out.printf("%-10s %-20s %-15s %-10.2f %-10.2f %-8d\n",
                    p.getId(), p.getName(), p.getType(), p.getBuyingPrice(), p.getSellingPrice(), p.getQuantity());
            }
        } catch (Exception e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
    }

    private void addNewProduct() {
        try {
            System.out.print("Product ID (e.g. PRO-103): ");
            String id = scanner.nextLine().trim();
            System.out.print("Product Name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Category/Type: ");
            String type = scanner.nextLine().trim();
            System.out.print("Description/Detail: ");
            String detail = scanner.nextLine().trim();
            System.out.print("Buying Price ($): ");
            double buying = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Selling Price ($): ");
            double selling = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Initial Quantity: ");
            int qty = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Supplier ID (Optional, press Enter to skip): ");
            String sellerId = scanner.nextLine().trim();

            if (inventoryService.addProduct(id, name, type, detail, buying, selling, qty, sellerId)) {
                System.out.println("--> Product added successfully!");
            }
        } catch (Exception e) {
            System.out.println("--> Error adding product: " + e.getMessage());
        }
    }

    private void manageSuppliers() {
        try {
            List<Seller> sellers = sellerDAO.getAllSellers();
            System.out.println("\n--- SUPPLIERS (SELLERS) ---");
            for (Seller s : sellers) {
                System.out.printf("[%s] %s | Company: %s | Contact: %s\n", s.getId(), s.getName(), s.getCompany(), s.getContact1());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void manageCustomers() {
        try {
            List<Customer> customers = customerDAO.getAllCustomers();
            System.out.println("\n--- STORE CUSTOMERS ---");
            for (Customer c : customers) {
                System.out.printf("[%s] %s | Email: %s | Contact: %s\n", c.getId(), c.getName(), c.getEmail(), c.getContact());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void processBilling() {
        try {
            System.out.println("\n--- POINT OF SALE (POS) BILLING ---");
            System.out.print("Enter Product ID to sell: ");
            String pid = scanner.nextLine().trim();
            Product p = inventoryService.getProduct(pid);
            if (p == null) {
                System.out.println("--> Product not found!");
                return;
            }
            System.out.printf("Selected: %s | Price: $%.2f | Stock: %d\n", p.getName(), p.getSellingPrice(), p.getQuantity());
            System.out.print("Enter Quantity to Purchase: ");
            int qty = Integer.parseInt(scanner.nextLine().trim());

            if (qty > p.getQuantity()) {
                System.out.println("--> Error: Insufficient stock!");
                return;
            }

            double subtotal = billingService.calculateLineTotal(p.getSellingPrice(), qty);
            System.out.printf("Subtotal: $%.2f\n", subtotal);
            System.out.print("Discount Percentage (0-100): ");
            double discount = Double.parseDouble(scanner.nextLine().trim());

            double finalTotal = billingService.calculateDiscountedTotal(subtotal, discount);
            System.out.printf("Final Total Amount: $%.2f\n", finalTotal);

            System.out.print("Enter Paid Amount ($): ");
            double paid = Double.parseDouble(scanner.nextLine().trim());
            double change = billingService.calculateReturnAmount(paid, finalTotal);
            System.out.printf("Change Return Amount: $%.2f\n", change);

            String invId = "INV-" + (System.currentTimeMillis() % 100000);
            BillingItem item = new BillingItem(invId, "", "", "CUS-101", p.getId(), p.getName(), p.getSellingPrice(), qty, subtotal, finalTotal, discount, (subtotal * discount)/100.0, paid, change);
            
            billingService.processTransaction(invId, "CUS-101", Collections.singletonList(item), discount, paid);
            System.out.println("--> Transaction completed and stock updated!");

            String pdf = billingService.generateReceiptPDF(invId, "Valued Customer", Collections.singletonList(item), finalTotal, discount, paid, change);
            if (pdf != null) {
                System.out.println("--> PDF Receipt Generated: " + pdf);
            }
        } catch (Exception e) {
            System.out.println("--> POS Error: " + e.getMessage());
        }
    }

    private void viewLowStockAlerts() {
        try {
            System.out.print("Enter Stock Threshold (e.g. 10): ");
            int threshold = Integer.parseInt(scanner.nextLine().trim());
            List<Product> lowStock = inventoryService.getLowStockAlerts(threshold);
            System.out.println("\n--- LOW STOCK ALERTS (Threshold <= " + threshold + ") ---");
            if (lowStock.isEmpty()) {
                System.out.println("All product stock levels are above threshold.");
            } else {
                for (Product p : lowStock) {
                    System.out.printf("ALERT: [%s] %s | Current Stock: %d (Needs Reorder)\n", p.getId(), p.getName(), p.getQuantity());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
