package inventorysoftware.model;

/**
 * Model representing a Product Supplier / Seller.
 */
public class Seller {
    private String id;
    private String name;
    private String company;
    private String address;
    private String productType;
    private String email;
    private String contact1;
    private String contact2;

    public Seller() {}

    public Seller(String id, String name, String company, String address, String productType, String email, String contact1, String contact2) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.address = address;
        this.productType = productType;
        this.email = email;
        this.contact1 = contact1;
        this.contact2 = contact2;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getProductType() { return productType; }
    public void setProductType(String productType) { this.productType = productType; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getContact1() { return contact1; }
    public void setContact1(String contact1) { this.contact1 = contact1; }

    public String getContact2() { return contact2; }
    public void setContact2(String contact2) { this.contact2 = contact2; }
}
