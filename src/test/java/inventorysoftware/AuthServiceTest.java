package inventorysoftware;

import inventorysoftware.dao.UserDAO;
import inventorysoftware.model.User;
import inventorysoftware.service.AuthService;

public class AuthServiceTest {

    public static boolean runTests() {
        System.out.println("Running AuthServiceTest...");
        boolean allPassed = true;

        try {
            UserDAO mockDAO = new UserDAO() {
                @Override
                public boolean registerUser(User u) {
                    return true;
                }
                @Override
                public User authenticate(String email, String password) {
                    if ("admin@varietystore.com".equals(email) && "admin123".equals(password)) {
                        return new User("Admin", "User", email, password, "9876543210");
                    }
                    return null;
                }
            };

            AuthService authService = new AuthService(mockDAO);

            User u = authService.login("admin@varietystore.com", "admin123");
            allPassed &= assertCondition(u != null && "Admin User".equals(u.getFullName()), "Valid login test");

            User invalid = authService.login("admin@varietystore.com", "wrongpass");
            allPassed &= assertCondition(invalid == null, "Invalid password login test");

            boolean reg = authService.register("Jane", "Doe", "jane@example.com", "pass123", "9876543210");
            allPassed &= assertCondition(reg, "User registration test");

        } catch (Exception e) {
            System.err.println("  [FAIL] Exception in AuthServiceTest: " + e.getMessage());
            return false;
        }

        return allPassed;
    }

    private static boolean assertCondition(boolean condition, String testName) {
        if (condition) {
            System.out.println("  [PASS] " + testName);
            return true;
        } else {
            System.err.println("  [FAIL] " + testName);
            return false;
        }
    }
}
