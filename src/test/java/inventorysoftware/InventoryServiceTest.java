package inventorysoftware;

import inventorysoftware.dao.ProductDAO;
import inventorysoftware.model.Product;
import inventorysoftware.service.InventoryService;
import java.util.HashMap;
import java.util.Map;

public class InventoryServiceTest {

    public static boolean runTests() {
        System.out.println("Running InventoryServiceTest...");
        boolean allPassed = true;

        try {
            Map<String, Product> db = new HashMap<>();
            Product p1 = new Product("TEST-101", "Keyboard", "Electronics", "Mechanical Keyboard", 30.0, 50.0, 20, "18-09-2026", "SEL-101");
            db.put(p1.getId(), p1);

            ProductDAO mockDAO = new ProductDAO() {
                @Override
                public Product getProductById(String id) {
                    return db.get(id);
                }
                @Override
                public boolean updateQuantity(String id, int qty) {
                    Product p = db.get(id);
                    if (p != null) {
                        p.setQuantity(qty);
                        return true;
                    }
                    return false;
                }
            };

            InventoryService service = new InventoryService(mockDAO);

            Product fetched = service.getProduct("TEST-101");
            allPassed &= assertCondition(fetched != null && "Keyboard".equals(fetched.getName()), "Fetch product test");

            boolean dec = service.decrementStock("TEST-101", 5);
            allPassed &= assertCondition(dec && db.get("TEST-101").getQuantity() == 15, "Decrement stock test");

            boolean overDecEx = false;
            try {
                service.decrementStock("TEST-101", 50);
            } catch (IllegalArgumentException e) {
                overDecEx = true;
            }
            allPassed &= assertCondition(overDecEx, "Over-decrement stock protection test");

        } catch (Exception e) {
            System.err.println("  [FAIL] Exception in InventoryServiceTest: " + e.getMessage());
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
