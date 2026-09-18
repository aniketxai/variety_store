package inventorysoftware.dao;

import inventorysoftware.model.BillingItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillingDAO {

    public boolean addBillingRecord(BillingItem item) throws SQLException {
        String sql = "INSERT INTO BILLING (id, date, time, c_id, p_id, name, price, quantity, total, total_amount, discount, d_amount, paid, returrn) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, item.getId());
            pst.setString(2, item.getDate());
            pst.setString(3, item.getTime());
            pst.setString(4, item.getCustomerId());
            pst.setString(5, item.getProductId());
            pst.setString(6, item.getProductName());
            pst.setDouble(7, item.getPrice());
            pst.setInt(8, item.getQuantity());
            pst.setDouble(9, item.getTotal());
            pst.setDouble(10, item.getTotalAmount());
            pst.setDouble(11, item.getDiscount());
            pst.setDouble(12, item.getDiscountAmount());
            pst.setDouble(13, item.getPaidAmount());
            pst.setDouble(14, item.getReturnAmount());
            return pst.executeUpdate() > 0;
        }
    }

    public List<BillingItem> getAllBillingRecords() throws SQLException {
        List<BillingItem> list = new ArrayList<>();
        String sql = "SELECT * FROM BILLING";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                list.add(mapRowToBillingItem(rs));
            }
        }
        return list;
    }

    public List<BillingItem> getBillingRecordsByInvoice(String invoiceId) throws SQLException {
        List<BillingItem> list = new ArrayList<>();
        String sql = "SELECT * FROM BILLING WHERE id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, invoiceId);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRowToBillingItem(rs));
                }
            }
        }
        return list;
    }

    private BillingItem mapRowToBillingItem(ResultSet rs) throws SQLException {
        return new BillingItem(
            rs.getString("id"),
            rs.getString("date"),
            rs.getString("time"),
            rs.getString("c_id"),
            rs.getString("p_id"),
            rs.getString("name"),
            rs.getDouble("price"),
            rs.getInt("quantity"),
            rs.getDouble("total"),
            rs.getDouble("total_amount"),
            rs.getDouble("discount"),
            rs.getDouble("d_amount"),
            rs.getDouble("paid"),
            rs.getDouble("returrn")
        );
    }
}
