package dao;
import model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerDAO {
    public boolean addCustomer(Customer customer) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO customers (name, email, phone) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPhone());
            int rowsInserted = ps.executeUpdate();
            conn.close();
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
