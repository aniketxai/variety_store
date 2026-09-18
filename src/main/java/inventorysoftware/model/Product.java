package inventorysoftware.model;

/**
 * Model representing an Inventory Product item.
 */
public class Product {
    private String id;
    private String name;
    private String type;
    private String detail;
    private double buyingPrice;
    private double sellingPrice;
    private int quantity;
    private String dateAdded;
    private String sellerId;

    public Product() {}

    public Product(String id, String name, String type, String detail, double buyingPrice, double sellingPrice, int quantity, String dateAdded, String sellerId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.detail = detail;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
        this.dateAdded = dateAdded;
        this.sellerId = sellerId;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }

    public double getBuyingPrice() { return buyingPrice; }
    public void setBuyingPrice(double buyingPrice) { this.buyingPrice = buyingPrice; }

    public double getSellingPrice() { return sellingPrice; }
    public void setSellingPrice(double sellingPrice) { this.sellingPrice = sellingPrice; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getDateAdded() { return dateAdded; }
    public void setDateAdded(String dateAdded) { this.dateAdded = dateAdded; }

    public String getSellerId() { return sellerId; }
    public void setSellerId(String sellerId) { this.sellerId = sellerId; }

    public double getProfitMargin() {
        return sellingPrice - buyingPrice;
    }

    @Override
    public String toString() {
        return "Product{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", price=" + sellingPrice + ", qty=" + quantity + '}';
    }
}
