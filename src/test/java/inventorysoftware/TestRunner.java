package inventorysoftware;

/**
 * Unified Automated Test Suite Runner.
 */
public class TestRunner {

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("      AUTOMATED UNIT TEST SUITE EXECUTION       ");
        System.out.println("=================================================");

        boolean passVal = ValidationUtilsTest.runTests();
        System.out.println("-------------------------------------------------");
        boolean passAuth = AuthServiceTest.runTests();
        System.out.println("-------------------------------------------------");
        boolean passInv = InventoryServiceTest.runTests();
        System.out.println("-------------------------------------------------");
        boolean passBill = BillingServiceTest.runTests();
        System.out.println("-------------------------------------------------");

        boolean overallPass = passVal && passAuth && passInv && passBill;
        if (overallPass) {
            System.out.println("RESULT: ALL UNIT TESTS PASSED SUCCESSFULLY! (100% Success)");
            System.exit(0);
        } else {
            System.err.println("RESULT: SOME UNIT TESTS FAILED!");
            System.exit(1);
        }
    }
}
