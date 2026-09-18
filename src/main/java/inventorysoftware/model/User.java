package inventorysoftware.model;

/**
 * Model representing a System User (Admin/Staff).
 */
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String contact;

    public User() {}

    public User(String firstName, String lastName, String email, String password, String contact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.contact = contact;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getFullName() {
        return (firstName != null ? firstName : "") + " " + (lastName != null ? lastName : "");
    }

    @Override
    public String toString() {
        return "User{" + "email='" + email + '\'' + ", name='" + getFullName() + '\'' + '}';
    }
}
