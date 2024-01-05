package com.qaitsolutions.qa.automation.core.config;

import java.util.Optional;

/**
 * Entity serves a singleton type object, which contains configuration data for framework.
 */
public class Config {

    private static final String REPORT_PATH_KEY = "report.path";
    private static final String REPORT_PATH_DEFAULT = "target/extent-reports/";

    private static final String REPORT_TYPE_KEY = "report.type";
    private static final String REPORT_TYPE_DEFAULT = "single";

    private static final String SCREENSHOTS_DIRECTORY = "screenshots";
    private static final String REPORT_NAME = "index";

    public static final ConfigDTO VALUES = get();

    /**
     * Creates a {@link ConfigDTO} pojo and sets data specific to it, and return it.
     *
     * @return {@link ConfigDTO} object with values loaded.
     */
    private static ConfigDTO get() {
        if (VALUES != null) return VALUES;

        var configDto = new ConfigDTO();

        var reportPath = Optional.of(System.getProperty(REPORT_PATH_KEY))
                .orElse(REPORT_PATH_DEFAULT);

        var reportType = Optional.of(System.getProperty(REPORT_TYPE_KEY))
                .orElse(REPORT_TYPE_DEFAULT);

        var screenshotPath = reportPath + "/" + SCREENSHOTS_DIRECTORY;

        configDto.setReportPath(reportPath);
        configDto.setReportType(reportType);
        configDto.setReportName(REPORT_NAME);
        configDto.setScreenshotPath(screenshotPath);
        configDto.setScreenshotDirectory(SCREENSHOTS_DIRECTORY);

        return configDto;
    }
}
