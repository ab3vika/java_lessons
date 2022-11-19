package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static sql.Constants.password;
import static sql.Constants.url;
import static sql.Constants.user;

public class Sql {

    private static final String SUCCESS = "%s operation was completed successfully%n";
    private static final String FAIL = "%s operation failed%n";

    private Connection con;
    private Statement s;
    private PreparedStatement ps;
    private ResultSet rs;

    public void connect() {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.printf(FAIL, "Connect");
        }
    }

    public void disconnect() {
        try {
            if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.printf(FAIL, "Disconnect");
        }
    }

    public void addClient(String name, String address, String phone) {
        try {
            ps = con.prepareStatement("INSERT INTO clients VALUES (0, ?, ?, ?);");
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, phone);
            boolean b = ps.executeUpdate() > 0;
            System.out.printf(b ? SUCCESS : FAIL, "Add client");
        } catch (SQLException e) {
            System.out.printf(FAIL, "Add client");
        }
    }

    public void deleteClient(String name) {
        try {
            ps = con.prepareStatement("DELETE FROM clients WHERE name = ?;");
            ps.setString(1, name);
            boolean b = ps.executeUpdate() > 0;
            System.out.printf(b ? SUCCESS : FAIL, "Delete client");
        } catch (SQLException e) {
            System.out.printf(FAIL, "Delete client");
        }
    }

    public void getClients() {
        try {
            s = con.createStatement();
            rs = s.executeQuery("SELECT * FROM clients;");
            System.out.println("Clients:");
            int i = 0;
            while (rs.next()) {
                System.out.printf("%d) %d, %s, %s, %s%n", ++i, rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
            }
            if (i == 0) {
                System.out.println("No clients");
            }
        } catch (SQLException e) {
            System.out.printf(FAIL, "Get clients");
        }
    }

    public void addCategory(String name) {
        try {
            ps = con.prepareStatement("INSERT INTO categories VALUES (0, ?);");
            ps.setString(1, name);
            boolean b = ps.executeUpdate() > 0;
            System.out.printf(b ? SUCCESS : FAIL, "Add category");
        } catch (SQLException e) {
            System.out.printf(FAIL, "Add category");
        }
    }

    public void deleteCategory(String name) {
        try {
            ps = con.prepareStatement("DELETE FROM categories WHERE name = ?;");
            ps.setString(1, name);
            boolean b = ps.executeUpdate() > 0;
            System.out.printf(b ? SUCCESS : FAIL, "Delete category");
        } catch (SQLException e) {
            System.out.printf(FAIL, "Delete category");
        }
    }

    public void getCategories() {
        try {
            s = con.createStatement();
            rs = s.executeQuery("SELECT * FROM categories;");
            System.out.println("Categories:");
            int i = 0;
            while (rs.next()) {
                System.out.printf("%d) %d, %s%n", ++i, rs.getInt(1), rs.getString(2));
            }
            if (i == 0) {
                System.out.println("No categories");
            }
        } catch (SQLException e) {
            System.out.printf(FAIL, "Get categories");
        }
    }

    public void addOrder(int clientId, int categoryId, int price) {
        try {
            ps = con.prepareStatement("INSERT INTO orders VALUES (0, ?, ?, ?, ?);");
            ps.setInt(1, clientId);
            ps.setInt(2, categoryId);
            ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            ps.setInt(4, price);
            boolean b = ps.executeUpdate() > 0;
            System.out.printf(b ? SUCCESS : FAIL, "Add order");
        } catch (SQLException e) {
            System.out.printf(FAIL, "Add order");
        }
    }

    public void deleteOrdersBy(String by, int id) {
        try {
            ps = con.prepareStatement("DELETE FROM orders WHERE " + by + "_id = ?;");
            ps.setInt(1, id);
            boolean b = ps.executeUpdate() > 0;
            System.out.printf(b ? SUCCESS : FAIL, "Delete orders by " + by);
        } catch (SQLException e) {
            System.out.printf(FAIL, "Delete orders by " + by);
        }
    }

    public void getOrders() {
        try {
            s = con.createStatement();
            rs = s.executeQuery("SELECT * FROM orders;");
            System.out.println("Orders:");
            int i = 0;
            while (rs.next()) {
                System.out.printf("%d) %d, %d, %s, %d%n", ++i, rs.getInt(2), rs.getInt(3),
                        rs.getTimestamp(4), rs.getInt(5));
            }
            if (i == 0) {
                System.out.println("No orders");
            }
        } catch (SQLException e) {
            System.out.printf(FAIL, "Get orders");
        }
    }

    public void getOrdersBy(String by, int id) {
        try {
            ps = con.prepareStatement("SELECT * FROM orders WHERE " + by + "_id = ?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            System.out.println("Orders:");
            int i = 0;
            while (rs.next()) {
                System.out.printf("%d) %d, %d, %s, %d%n", ++i, rs.getInt(2), rs.getInt(3),
                        rs.getTimestamp(4), rs.getInt(5));
            }
            if (i == 0) {
                System.out.println("No orders");
            }
        } catch (SQLException e) {
            System.out.printf(FAIL, "Get orders by " + by);
        }
    }

}
