package inventorysoftware;

import inventorysoftware.service.BillingService;

public class BillingServiceTest {

    public static boolean runTests() {
        System.out.println("Running BillingServiceTest...");
        boolean allPassed = true;

        BillingService service = new BillingService(null, null);

        double lineTotal = service.calculateLineTotal(25.0, 4);
        allPassed &= assertCondition(lineTotal == 100.0, "Line total calculation test (25 * 4 = 100)");

        double discounted = service.calculateDiscountedTotal(100.0, 10.0);
        allPassed &= assertCondition(discounted == 90.0, "Discount calculation test (100 - 10% = 90)");

        double change = service.calculateReturnAmount(100.0, 90.0);
        allPassed &= assertCondition(change == 10.0, "Change return amount test (100 - 90 = 10)");

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
