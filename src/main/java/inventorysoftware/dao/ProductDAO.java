package inventorysoftware.dao;

import inventorysoftware.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public boolean addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO PRODUCT (p_id, p_name, p_type, p_detail, buying, selling, quantity, date, s_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, product.getId());
            pst.setString(2, product.getName());
            pst.setString(3, product.getType());
            pst.setString(4, product.getDetail());
            pst.setDouble(5, product.getBuyingPrice());
            pst.setDouble(6, product.getSellingPrice());
            pst.setInt(7, product.getQuantity());
            pst.setString(8, product.getDateAdded());
            pst.setString(9, product.getSellerId());
            return pst.executeUpdate() > 0;
        }
    }

    public boolean updateProduct(Product product) throws SQLException {
        String sql = "UPDATE PRODUCT SET p_name=?, p_type=?, p_detail=?, buying=?, selling=?, quantity=?, date=?, s_id=? WHERE p_id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, product.getName());
            pst.setString(2, product.getType());
            pst.setString(3, product.getDetail());
            pst.setDouble(4, product.getBuyingPrice());
            pst.setDouble(5, product.getSellingPrice());
            pst.setInt(6, product.getQuantity());
            pst.setString(7, product.getDateAdded());
            pst.setString(8, product.getSellerId());
            pst.setString(9, product.getId());
            return pst.executeUpdate() > 0;
        }
    }

    public boolean updateQuantity(String productId, int newQuantity) throws SQLException {
        String sql = "UPDATE PRODUCT SET quantity=? WHERE p_id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, newQuantity);
            pst.setString(2, productId);
            return pst.executeUpdate() > 0;
        }
    }

    public boolean deleteProduct(String productId) throws SQLException {
        String sql = "DELETE FROM PRODUCT WHERE p_id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, productId);
            return pst.executeUpdate() > 0;
        }
    }

    public Product getProductById(String id) throws SQLException {
        String sql = "SELECT * FROM PRODUCT WHERE p_id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return mapRowToProduct(rs);
                }
            }
        }
        return null;
    }

    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCT";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                products.add(mapRowToProduct(rs));
            }
        }
        return products;
    }

    public List<Product> getLowStockProducts(int threshold) throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCT WHERE quantity <= ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, threshold);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    products.add(mapRowToProduct(rs));
                }
            }
        }
        return products;
    }

    private Product mapRowToProduct(ResultSet rs) throws SQLException {
        return new Product(
            rs.getString("p_id"),
            rs.getString("p_name"),
            rs.getString("p_type"),
            rs.getString("p_detail"),
            rs.getDouble("buying"),
            rs.getDouble("selling"),
            rs.getInt("quantity"),
            rs.getString("date"),
            rs.getString("s_id")
        );
    }
}
