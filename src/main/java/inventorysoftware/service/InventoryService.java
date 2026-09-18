package inventorysoftware.service;

import inventorysoftware.dao.ProductDAO;
import inventorysoftware.model.Product;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class InventoryService {

    private final ProductDAO productDAO;

    public InventoryService() {
        this.productDAO = new ProductDAO();
    }

    public InventoryService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public boolean addProduct(String id, String name, String type, String detail, double buying, double selling, int quantity, String sellerId) throws SQLException {
        if (!ValidationUtils.isNotEmpty(id)) {
            throw new IllegalArgumentException("Product ID cannot be empty.");
        }
        if (!ValidationUtils.isNotEmpty(name)) {
            throw new IllegalArgumentException("Product Name cannot be empty.");
        }
        if (!ValidationUtils.isNonNegativeNumber(buying) || !ValidationUtils.isNonNegativeNumber(selling)) {
            throw new IllegalArgumentException("Prices must be non-negative.");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }

        String dateStr = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        Product p = new Product(id, name, type, detail, buying, selling, quantity, dateStr, sellerId);
        return productDAO.addProduct(p);
    }

    public boolean updateStock(String productId, int newQuantity) throws SQLException {
        if (newQuantity < 0) {
            throw new IllegalArgumentException("Stock quantity cannot be negative.");
        }
        return productDAO.updateQuantity(productId, newQuantity);
    }

    public boolean decrementStock(String productId, int quantitySold) throws SQLException {
        Product p = productDAO.getProductById(productId);
        if (p == null) {
            throw new IllegalArgumentException("Product not found: " + productId);
        }
        if (p.getQuantity() < quantitySold) {
            throw new IllegalArgumentException("Insufficient stock for product: " + p.getName() + " (Available: " + p.getQuantity() + ")");
        }
        return productDAO.updateQuantity(productId, p.getQuantity() - quantitySold);
    }

    public Product getProduct(String id) throws SQLException {
        return productDAO.getProductById(id);
    }

    public List<Product> getAllProducts() throws SQLException {
        return productDAO.getAllProducts();
    }

    public List<Product> getLowStockAlerts(int threshold) throws SQLException {
        return productDAO.getLowStockProducts(threshold);
    }
}
