package com.qaitsolutions.pframe.core.testng;

import com.qaitsolutions.pframe.core.config.Config;
import com.qaitsolutions.pframe.core.exceptions.FrameworkException;
import com.qaitsolutions.pframe.core.extent_reporting.ExtentLogger;
import com.qaitsolutions.pframe.core.extent_reporting.Reporting;
import com.qaitsolutions.pframe.core.logging.Log;
import lombok.NonNull;
import org.testng.*;

import java.util.Arrays;
import java.util.Optional;

/**
 * TestNg implementation of listener that will be used to configure the test execution and reporting.
 * This links testNg, extent report and log4j.
 * <p>
 *
 * @author Iulian Andrei (iulian.andrei@qaitsolutions.com)
 * @since 1.0
 */
public class PFrameListener implements
        ISuiteListener,
        ITestListener,
        IConfigurationListener {

    private static Reporting report;
    protected String currentNodeName;

    private static final String BEFORE_METHOD_NAME = "Before Method";
    private static final String AFTER_METHOD_NAME = "After Method";

    @Override
    public void onStart(ISuite iSuite) {
        var reportName = generateReportFilename(iSuite);
        report = new Reporting().createReport(reportName);
    }

    @Override
    public void onFinish(ISuite iSuite) {
        report.flush();
    }

    @Override
    public void beforeConfiguration(ITestResult tr) {

        var message = "Configuration [%s] has started";

        var className = tr.getTestClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);

        if (tr.getMethod().isBeforeSuiteConfiguration()) {
            report.createTest("Suite Setup").createNode(currentNodeName = "Setup");
            Log.info(message, currentNodeName);
        }

        if (tr.getMethod().isBeforeClassConfiguration()) {
            report.createTest(className).createNode(currentNodeName = "Test Setup");
            Log.info(message, currentNodeName);
        }

        if (tr.getMethod().isBeforeMethodConfiguration()) {
            report.createTest(className).createNode(currentNodeName = BEFORE_METHOD_NAME);
            Log.info(message, currentNodeName);
        }

        if (tr.getMethod().isAfterMethodConfiguration()) {
            Log.info(message, AFTER_METHOD_NAME);
        }

        if (tr.getMethod().isAfterClassConfiguration()) {
            report.createNode(currentNodeName = "Test Teardown");
            Log.info(message, currentNodeName);
        }

        if (tr.getMethod().isAfterSuiteConfiguration()) {
            report.createTest("Suite Teardown").createNode(currentNodeName = "Teardown");
            Log.info(message, currentNodeName);
        }
    }

    @Override
    public void onConfigurationSuccess(ITestResult tr) {
        var method = tr.getMethod();

        if (method.isAfterGroupsConfiguration()
                || method.isAfterTestConfiguration()) {
            return;
        }

        var message = "Configuration [%s] finished with success";

        if (method.isAfterMethodConfiguration()) {
            Log.info(message, AFTER_METHOD_NAME);
        } else {
            Log.info(message, currentNodeName);
        }
    }

    @Override
    public void onConfigurationFailure(ITestResult iTestResult) {
        var method = iTestResult.getMethod();

        if (method.isAfterClassConfiguration() || method.isAfterSuiteConfiguration()) {
            var e = iTestResult.getThrowable();

            if (e != null && !(e instanceof AssertionError))
                Log.fail("Configuration failed unexpectedly", e);

            Log.info("Configuration [%s] failed", currentNodeName);
        }
    }

    @Override
    public void onConfigurationSkip(ITestResult tr) {
        var method = tr.getMethod();

        if (method.isAfterClassConfiguration() || method.isAfterSuiteConfiguration())
            Log.skip("Configuration [%s] was skipped", currentNodeName);
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

        var className = iTestResult.getTestClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);

        report.createTest(className);

        this.currentNodeName = generateTestName(iTestResult);
        if (report.isCurrentNode(BEFORE_METHOD_NAME)) {
            report.renameCurrentNode(this.currentNodeName);
        } else {
            report.createNode(this.currentNodeName);
        }

        Log.info("Test [%s] has started", currentNodeName);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info("Test [%s] finished with success", currentNodeName);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        var e = iTestResult.getThrowable();

        if (e != null && !(e instanceof AssertionError))
            Log.fail("Test failed unexpectedly", e);

        Log.info("Test [%s] failed", currentNodeName);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.skip("Test [%s] was skipped", currentNodeName);
    }

    /**
     * Generates a test name that has the name of the method, plus the parameters if they are present
     * <p>
     *
     * @param testResult The entity that will provide the test details
     * @return A {@link String} with the method name + parameters, if they exist. e.g. testName[NAME,1,true]
     */
    private String generateTestName(@NonNull final ITestResult testResult) {
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
     * <p>
     *
     * @return {@link String}, e.g. index.html or suite_name_658723942
     */
    private String generateReportFilename(@NonNull final ISuite iSuite) {

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
    public static Optional<ExtentLogger> getLog() {
        ExtentLogger log = report != null ? report.log() : null;
        return Optional.ofNullable(log);
    }
}
