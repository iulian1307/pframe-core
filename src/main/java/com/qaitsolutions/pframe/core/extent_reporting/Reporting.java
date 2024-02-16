package com.qaitsolutions.pframe.core.extent_reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qaitsolutions.pframe.core.config.Config;
import com.qaitsolutions.pframe.core.exceptions.FrameworkException;
import lombok.NonNull;

/**
 * Handles the logic of the ExtentReport in a user-friendly manner.
 * <p>
 *
 * @author Iulian Andrei (iulian.andrei@qaitsolutions.com)
 * @since 1.0
 */
public final class Reporting {

    private ExtentReports report;
    private ExtentLogger logger;
    private ExtentTest currentTest;
    private ExtentTest currentNode;

    /**
     * Creates an Extent Report object with current report path
     * <p>
     *
     * @param filename Filename of html report (e.g. index).
     * @return A self reference.
     */
    public Reporting createReport(@NonNull final String filename) {
        return createReport(Config.VALUES.getReportPath(), filename);
    }

    /**
     * Creates an Extent Report object.
     * <p>
     *
     * @param path     Path where the report will be stored (e.g. target/reports/ or target/reports).
     * @param filename Filename of html report (e.g. index).
     * @return A self reference.
     */
    public Reporting createReport(@NonNull String path, @NonNull String filename) {
        if (!path.endsWith("/")) path = path + "/";
        if (!filename.contains(".html")) filename = filename + ".html";

        this.report = new ExtentReports();
        this.report.attachReporter(generateSparkReporter(path + filename));

        return this;
    }

    /**
     * Creates a new test with given name.
     * <p>
     *
     * @param name Name of the new test.
     * @return A self reference.
     */
    public Reporting createTest(@NonNull final String name) {
        if (!isCurrentTest(name)) this.currentTest = report.createTest(name);
        return this;
    }

    /**
     * Renames the current test in Extent Reports.
     * <p>
     *
     * @param name Name to used in renaming.
     * @return A self reference.
     */
    public Reporting renameCurrentTest(@NonNull final String name) {
        if (this.currentTest != null)
            this.currentTest.getModel().setName(name);

        return this;
    }

    /**
     * Checks if the name of the current test is as given.
     * <p>
     *
     * @param name Name to be checked against current test name.
     * @return True if the current test name is as given | False if the current test name is not as given.
     */
    public boolean isCurrentTest(@NonNull final String name) {
        return currentTest != null && currentTest.getModel().getName().equals(name);
    }

    /**
     * Creates a new test node with given name.
     * <p>
     *
     * @param name Name of the new node.
     * @return A self reference.
     */
    public Reporting createNode(@NonNull final String name) {
        if (this.currentTest == null)
            throw new FrameworkException("Create test before trying to create node");

        if (!isCurrentNode(name)) currentNode = currentTest.createNode(name);

        return this;
    }

    /**
     * Renames the current node in Extent Reports.
     * <p>
     *
     * @param name Name to used in renaming.
     * @return A self reference.
     */
    public Reporting renameCurrentNode(@NonNull final String name) {
        if (this.currentTest == null)
            throw new FrameworkException("Create test before trying to create node");

        currentNode.getModel().setName(name);

        return this;
    }

    /**
     * Checks if the name of the current node is as given.
     * <p>
     *
     * @param name Name to be checked against current node name.
     * @return True if the current node name is as given | False if the current node name is not as given.
     */
    public boolean isCurrentNode(@NonNull final String name) {
        return currentNode != null && currentNode.getModel().getName().equals(name);
    }

    /**
     * Generates report.
     */
    public void flush() {
        if (this.report == null) throw new FrameworkException("Report was not created");
        this.report.flush();
    }

    /**
     * Provides access to current log.
     * <p>
     *
     * @return Log from existing reporting.
     */
    public ExtentLogger log() {
        if (this.logger == null) this.logger = new ExtentLogger();
        logger.setLog(this.currentNode);

        return logger;
    }

    /**
     * Getter for a new {@link ExtentSparkReporter} with given filename.
     * <p>
     *
     * @param filename Name of the report file that will be generated.
     * @return {@link ExtentSparkReporter}.
     */
    private ExtentSparkReporter generateSparkReporter(@NonNull final String filename) {
        var reporter = new ExtentSparkReporter(filename);

        reporter.config().setDocumentTitle(filename);
        reporter.config().setReportName(filename);

        return reporter;
    }
}
