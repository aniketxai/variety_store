package inventorysoftware.service;

import inventorysoftware.dao.UserDAO;
import inventorysoftware.model.User;
import java.sql.SQLException;

public class AuthService {

    private final UserDAO userDAO;

    public AuthService() {
        this.userDAO = new UserDAO();
    }

    public AuthService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean register(String firstName, String lastName, String email, String password, String contact) throws IllegalArgumentException, SQLException {
        if (!ValidationUtils.isNotEmpty(firstName)) {
            throw new IllegalArgumentException("First name cannot be empty.");
        }
        if (!ValidationUtils.isNotEmpty(email) || !ValidationUtils.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email address.");
        }
        if (!ValidationUtils.isNotEmpty(password) || password.length() < 4) {
            throw new IllegalArgumentException("Password must be at least 4 characters long.");
        }

        User user = new User(firstName, lastName, email, password, contact);
        return userDAO.registerUser(user);
    }

    public User login(String email, String password) throws SQLException {
        if (!ValidationUtils.isNotEmpty(email) || !ValidationUtils.isNotEmpty(password)) {
            return null;
        }
        return userDAO.authenticate(email, password);
    }
}
