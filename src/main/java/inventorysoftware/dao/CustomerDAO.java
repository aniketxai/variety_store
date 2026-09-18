package inventorysoftware.dao;

import inventorysoftware.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public boolean addCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO CUSTOMER (c_id, c_name, c_address, c_email, contact, gender) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, customer.getId());
            pst.setString(2, customer.getName());
            pst.setString(3, customer.getAddress());
            pst.setString(4, customer.getEmail());
            pst.setString(5, customer.getContact());
            pst.setString(6, customer.getGender());
            return pst.executeUpdate() > 0;
        }
    }

    public boolean updateCustomer(Customer customer) throws SQLException {
        String sql = "UPDATE CUSTOMER SET c_name=?, c_address=?, c_email=?, contact=?, gender=? WHERE c_id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, customer.getName());
            pst.setString(2, customer.getAddress());
            pst.setString(3, customer.getEmail());
            pst.setString(4, customer.getContact());
            pst.setString(5, customer.getGender());
            pst.setString(6, customer.getId());
            return pst.executeUpdate() > 0;
        }
    }

    public boolean deleteCustomer(String id) throws SQLException {
        String sql = "DELETE FROM CUSTOMER WHERE c_id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, id);
            return pst.executeUpdate() > 0;
        }
    }

    public Customer getCustomerById(String id) throws SQLException {
        String sql = "SELECT * FROM CUSTOMER WHERE c_id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return mapRowToCustomer(rs);
                }
            }
        }
        return null;
    }

    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM CUSTOMER";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                customers.add(mapRowToCustomer(rs));
            }
        }
        return customers;
    }

    private Customer mapRowToCustomer(ResultSet rs) throws SQLException {
        return new Customer(
            rs.getString("c_id"),
            rs.getString("c_name"),
            rs.getString("c_address"),
            rs.getString("c_email"),
            rs.getString("contact"),
            rs.getString("gender")
        );
    }
}
