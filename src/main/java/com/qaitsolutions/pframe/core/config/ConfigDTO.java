package com.qaitsolutions.pframe.core.config;

import lombok.*;

/**
 * DTO that will be used to access configuration data.
 * <p>
 * @author Iulian Andrei (iulian.andrei@qaitsolutions.com)
 * @since 1.0
 */
@Getter @Setter
@RequiredArgsConstructor @NoArgsConstructor
public final class ConfigDTO {

    @NonNull private String reportPath;
    @NonNull private String reportType;
    @NonNull private String reportName;
    @NonNull private String screenshotPath;
    @NonNull private String screenshotDirectory;
}
