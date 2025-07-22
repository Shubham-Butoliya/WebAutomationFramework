package com.web.framework.testUtils;

import com.web.framework.utils.ExtentLogger;
import org.testng.Assert;

public class AssertUtils {

    public static void assertEquals(Object actual, Object expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
            ExtentLogger.logPass("Assertion Passed: " + message + " | Expected: " + expected + ", Actual: " + actual);
        } catch (AssertionError e) {
            ExtentLogger.logFail("Assertion Failed: " + message + " | Expected: " + expected + ", Actual: " + actual);
            throw e;
        }
    }
}
