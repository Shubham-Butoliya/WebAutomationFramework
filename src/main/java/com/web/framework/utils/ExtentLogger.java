package com.web.framework.utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentLogger {

    private static final ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<>();

    public static void setTest(ExtentTest test) {
        extentTestThread.set(test);
    }

    public static ExtentTest getTest() {
        return extentTestThread.get();
    }

    public static void logInfo(String message) {
        getTest().info(message);
    }

    public static void logPass(String message) {
        getTest().pass(message);
    }

    public static void logFail(String message) {
        getTest().fail(message);
    }

    public static void logWarning(String message) {
        getTest().warning(message);
    }

    public static void clear() {
        extentTestThread.remove();
    }

}
