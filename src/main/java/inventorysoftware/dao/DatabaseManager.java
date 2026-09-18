package inventorysoftware.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Singleton Central Database Manager handling H2 embedded connections and schema setup.
 */
public class DatabaseManager {

    private static final String DB_NAME = "includedata";
    private static final String DB_URL = "jdbc:h2:./database/" + DB_NAME;
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("H2 Driver not found in classpath: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        return conn;
    }

    /**
     * Initializes database schema from database/schema.sql if tables do not exist.
     */
    public static synchronized void initializeSchema() {
        File schemaFile = new File("database/schema.sql");
        if (!schemaFile.exists()) {
            return;
        }

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             BufferedReader reader = new BufferedReader(new FileReader(schemaFile))) {

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("--") || line.isEmpty()) {
                    continue;
                }
                sb.append(line).append(" ");
                if (line.endsWith(";")) {
                    String sql = sb.toString().replace(";", "").trim();
                    try {
                        stmt.execute(sql);
                    } catch (SQLException e) {
                        // Table may already exist
                    }
                    sb.setLength(0);
                }
            }
            System.out.println("[DatabaseManager] Database initialized successfully.");
        } catch (Exception e) {
            System.err.println("[DatabaseManager] Schema initialization note: " + e.getMessage());
        }
    }
}
