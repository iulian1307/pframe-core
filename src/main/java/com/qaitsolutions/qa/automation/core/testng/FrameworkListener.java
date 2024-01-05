package com.qaitsolutions.qa.automation.core.testng;

import com.qaitsolutions.qa.automation.core.config.Config;
import com.qaitsolutions.qa.automation.core.exceptions.FrameworkException;
import com.qaitsolutions.qa.automation.core.extent_reporting.ExtentLogger;
import com.qaitsolutions.qa.automation.core.extent_reporting.Reporting;
import com.qaitsolutions.qa.automation.core.extent_reporting.ReportingFactory;
import org.testng.*;

import java.util.Arrays;
import java.util.Optional;

/**
 * TestNg implementation of listener that will be used to configure the test execution and reporting
 */
public class FrameworkListener implements
        ISuiteListener,
        ITestListener,
        IClassListener {

    private static Reporting reports;
    private String currentTestName;

    @Override
    public void onStart(ISuite iSuite) {
        reports = ReportingFactory.getReporter(generateReportFilename(iSuite));

        if (isBeforeSuite(iSuite))
            reports.createTest("@beforeSuite").createNode("@beforeSuite");
    }

    @Override
    public void onFinish(ISuite iSuite) {
        reports.flush();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        if (isAfterSuite(iTestContext))
            reports.createTest("Suite Teardown").createNode("Suite Teardown");
    }

    @Override
    public void onBeforeClass(ITestClass iTestClass) {
        if (iTestClass.getBeforeClassMethods().length > 0) {

            var className = iTestClass.getName();
            className = className.substring(className.lastIndexOf(".") + 1);

            reports.createTest(className).createNode("Test Setup");
        }
    }

    @Override
    public void onAfterClass(ITestClass iTestClass) {
        if (iTestClass.getAfterClassMethods().length > 0)
            reports.createNode("Test TearDown");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        var className = iTestResult.getTestClass().getName();

        className = className.substring(className.lastIndexOf(".") + 1);

        this.currentTestName = generateTestName(iTestResult);

        if (!reports.testExists(className))
            reports.createTest(className);

        reports.createNode(this.currentTestName);
        Log.info("Test [" + this.currentTestName + "] has started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info("Test [" + this.currentTestName + "] finished with success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        var e = iTestResult.getThrowable();

        if (e != null && !(e instanceof AssertionError))
            Log.fail("Test failed unexpectedly", e);

        Log.info("Test [" + this.currentTestName + "] failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.skip("Test [" + this.currentTestName + "] was skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    /**
     * Method checks is current test method is {@link org.testng.annotations.AfterSuite}
     *
     * @param iTestContext TestContext data to determine if method is {@link org.testng.annotations.AfterSuite}
     * @return True if the method is {@link org.testng.annotations.AfterSuite}, or false if it is not
     */
    private boolean isAfterSuite(ITestContext iTestContext) {
        var allMethods = iTestContext.getSuite().getAllMethods();

        for (var method : allMethods) {
            var afterSuiteMethods = method.getTestClass().getAfterSuiteMethods();

            if (afterSuiteMethods.length > 0) return true;
        }

        return false;
    }

    /**
     * Method checks is current test method is {@link org.testng.annotations.BeforeSuite}
     *
     * @param iSuite Suite data to determine if method is {@link org.testng.annotations.BeforeSuite}
     * @return True if the method is {@link org.testng.annotations.BeforeSuite}, or false if it is not
     */
    private boolean isBeforeSuite(ISuite iSuite) {
        var allMethods = iSuite.getAllMethods();

        for (var method : allMethods) {
            var beforeSuiteMethods = method.getTestClass().getBeforeSuiteMethods();
            if (beforeSuiteMethods.length > 0) return true;
        }

        return false;
    }

    /**
     * Generates a test name that has the name of the method, plus the parameters if they are present
     *
     * @param testResult The entity that will provide the test details
     * @return A {@link String} with the method name + parameters, if they exist. e.g. testName[NAME,1,true]
     */
    private String generateTestName(ITestResult testResult) {
        var description = testResult.getMethod().getDescription();

        var name = description != null && !description.isEmpty() ? description : testResult.getName();
        var parameters = testResult.getParameters();

        if (parameters.length != 0)
            name = name + Arrays.toString(testResult.getParameters());

        return name;
    }

    /**
     * Generates a report filename based on the config file. Either it will be a default value, or it will
     * generate from the {@link ISuite#getSuiteState()} and {@link System#currentTimeMillis()}.
     *
     * @return {@link String}, e.g. index.html or suite_name_658723942
     */
    private String generateReportFilename(ISuite iSuite) {

        final var reportType = Config.VALUES.getReportType();

        return switch (reportType) {
            case "multi" -> iSuite.getName().replaceAll(" ", "_").toLowerCase() + "_" + System.currentTimeMillis();
            case "single" -> Config.VALUES.getReportName();
            default -> throw new FrameworkException("report.type parameter is not set correctly, use single or multi");
        };
    }

    /**
     * @return Extent report log
     */
    static Optional<ExtentLogger> getLog() {
        ExtentLogger log = reports != null ? reports.log() : null;
        return Optional.ofNullable(log);
    }
}
