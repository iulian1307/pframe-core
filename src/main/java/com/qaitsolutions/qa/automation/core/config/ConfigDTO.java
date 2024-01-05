package com.qaitsolutions.qa.automation.core.config;

import lombok.*;

/**
 * DTO that will be used to access configuration data.
 */
@Getter @Setter
@RequiredArgsConstructor @NoArgsConstructor
public class ConfigDTO {

    @NonNull private String reportPath;
    @NonNull private String reportType;
    @NonNull private String reportName;
    @NonNull private String screenshotPath;
    @NonNull private String screenshotDirectory;
}
