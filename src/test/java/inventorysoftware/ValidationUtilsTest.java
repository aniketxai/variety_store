package inventorysoftware;

import inventorysoftware.service.ValidationUtils;

public class ValidationUtilsTest {

    public static boolean runTests() {
        System.out.println("Running ValidationUtilsTest...");
        boolean allPassed = true;

        allPassed &= assertCondition(ValidationUtils.isValidEmail("user@example.com"), "Valid email test");
        allPassed &= assertCondition(!ValidationUtils.isValidEmail("invalid-email"), "Invalid email test");
        allPassed &= assertCondition(ValidationUtils.isValidPhone("9876543210"), "Valid phone test");
        allPassed &= assertCondition(!ValidationUtils.isValidPhone("abc"), "Invalid phone test");
        allPassed &= assertCondition(ValidationUtils.isNotEmpty("Hello"), "IsNotEmpty valid test");
        allPassed &= assertCondition(!ValidationUtils.isNotEmpty("  "), "IsNotEmpty empty test");
        allPassed &= assertCondition(ValidationUtils.isPositiveNumber(15.5), "Positive number test");
        allPassed &= assertCondition(!ValidationUtils.isPositiveNumber(-5), "Negative number test");

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
