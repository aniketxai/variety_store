package inventorysoftware.dao;

import inventorysoftware.model.Seller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerDAO {

    public boolean addSeller(Seller seller) throws SQLException {
        String sql = "INSERT INTO SELLER (s_id, name, company, address, product_type, email, contact1, contact2) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, seller.getId());
            pst.setString(2, seller.getName());
            pst.setString(3, seller.getCompany());
            pst.setString(4, seller.getAddress());
            pst.setString(5, seller.getProductType());
            pst.setString(6, seller.getEmail());
            pst.setString(7, seller.getContact1());
            pst.setString(8, seller.getContact2());
            return pst.executeUpdate() > 0;
        }
    }

    public boolean updateSeller(Seller seller) throws SQLException {
        String sql = "UPDATE SELLER SET name=?, company=?, address=?, product_type=?, email=?, contact1=?, contact2=? WHERE s_id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, seller.getName());
            pst.setString(2, seller.getCompany());
            pst.setString(3, seller.getAddress());
            pst.setString(4, seller.getProductType());
            pst.setString(5, seller.getEmail());
            pst.setString(6, seller.getContact1());
            pst.setString(7, seller.getContact2());
            pst.setString(8, seller.getId());
            return pst.executeUpdate() > 0;
        }
    }

    public boolean deleteSeller(String id) throws SQLException {
        String sql = "DELETE FROM SELLER WHERE s_id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, id);
            return pst.executeUpdate() > 0;
        }
    }

    public Seller getSellerById(String id) throws SQLException {
        String sql = "SELECT * FROM SELLER WHERE s_id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return mapRowToSeller(rs);
                }
            }
        }
        return null;
    }

    public List<Seller> getAllSellers() throws SQLException {
        List<Seller> sellers = new ArrayList<>();
        String sql = "SELECT * FROM SELLER";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                sellers.add(mapRowToSeller(rs));
            }
        }
        return sellers;
    }

    private Seller mapRowToSeller(ResultSet rs) throws SQLException {
        return new Seller(
            rs.getString("s_id"),
            rs.getString("name"),
            rs.getString("company"),
            rs.getString("address"),
            rs.getString("product_type"),
            rs.getString("email"),
            rs.getString("contact1"),
            rs.getString("contact2")
        );
    }
}
