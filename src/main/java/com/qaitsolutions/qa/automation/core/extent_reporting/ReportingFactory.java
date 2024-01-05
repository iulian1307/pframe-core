package com.qaitsolutions.qa.automation.core.extent_reporting;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory statically creates {@link Reporting} entity
 */
public class ReportingFactory {

    private static final Map<String, Reporting> report = new HashMap<>();

    /**
     * @param filename Name of the report file that will be created
     * @return new reporter if new filename, or existing reporter has been previously created
     */
    public static Reporting getReporter(@NonNull final String filename) {
        if (report.isEmpty() || !report.containsKey(filename)) {
            report.put(filename, new Reporting().create(filename));
        }

        return report.get(filename);
    }
}
