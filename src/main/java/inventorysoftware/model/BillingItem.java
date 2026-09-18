package inventorysoftware.model;

/**
 * Model representing a POS transaction line item / bill record.
 */
public class BillingItem {
    private String id;
    private String date;
    private String time;
    private String customerId;
    private String productId;
    private String productName;
    private double price;
    private int quantity;
    private double total;
    private double totalAmount;
    private double discount;
    private double discountAmount;
    private double paidAmount;
    private double returnAmount;

    public BillingItem() {}

    public BillingItem(String id, String date, String time, String customerId, String productId, String productName, double price, int quantity, double total, double totalAmount, double discount, double discountAmount, double paidAmount, double returnAmount) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.customerId = customerId;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.totalAmount = totalAmount;
        this.discount = discount;
        this.discountAmount = discountAmount;
        this.paidAmount = paidAmount;
        this.returnAmount = returnAmount;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public double getDiscount() { return discount; }
    public void setDiscount(double discount) { this.discount = discount; }

    public double getDiscountAmount() { return discountAmount; }
    public void setDiscountAmount(double discountAmount) { this.discountAmount = discountAmount; }

    public double getPaidAmount() { return paidAmount; }
    public void setPaidAmount(double paidAmount) { this.paidAmount = paidAmount; }

    public double getReturnAmount() { return returnAmount; }
    public void setReturnAmount(double returnAmount) { this.returnAmount = returnAmount; }
}
