package com.qaitsolutions.qa.automation.core.extent_reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qaitsolutions.qa.automation.core.config.Config;
import com.qaitsolutions.qa.automation.core.exceptions.FrameworkException;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles the logic of the ExtentReport in a user-friendly manner
 */
public class Reporting {

    private ExtentReports report;
    private ExtentTest mainTest;
    private ExtentTest nodeTest;
    private ExtentLogger logger;

    private final List<String> testNames = new ArrayList<>();

    /**
     * Creates a reporting object using a given path
     *
     * @param filename path+filename to output html
     * @return instantiated extent reports
     */
    Reporting create(String filename) {
        this.report = new ExtentReports();

        filename = Config.VALUES.getReportPath() + filename + ".html";

        this.report.attachReporter(getSparkReporter(filename));

        return this;
    }

    /**
     * Creates a reporting object using a default set path
     *
     * @return instantiated extent reports
     */
    Reporting create() {
        return create("report");
    }

    /**
     * Creates a new test with given name
     *
     * @param name Name of the new test
     * @return current object
     */
    public Reporting createTest(String name) {
        this.testNames.add(name);
        this.mainTest = this.report.createTest(name);

        return this;
    }

    /**
     * Creates a new test node with given name
     *
     * @param name Name of the new node
     * @return current object
     */
    public Reporting createNode(String name) {
        if (this.mainTest == null)
            throw new FrameworkException("[extent_reporting] Create test before trying to create node");

        this.nodeTest = this.mainTest.createNode(name);
        return this;
    }

    /**
     * Generates report
     */
    public void flush() {
        if (this.report == null) throw new FrameworkException("[extent_reporting] Reporting was not created");
        this.testNames.clear();

        this.report.flush();
    }

    /**
     * Provides access to current log
     *
     * @return Log from existing reporting
     */
    public ExtentLogger log() {
        if (this.nodeTest == null) throw new FrameworkException("[extent_reporting] Create test before trying to log");
        if (this.logger == null) this.logger = new ExtentLogger();

        logger.setLog(this.nodeTest);

        return logger;
    }

    public boolean testExists(String name) {
        return testNames.contains(name);
    }

    /**
     * Getter for a new {@link ExtentSparkReporter} with given filename
     *
     * @param filename Name of the report file that will be generated
     * @return {@link ExtentSparkReporter}
     */
    private ExtentSparkReporter getSparkReporter(String filename) {
        var reporter = new ExtentSparkReporter(filename);

        reporter.config().setDocumentTitle(filename);
        reporter.config().setReportName(filename);

        return reporter;
    }
}
