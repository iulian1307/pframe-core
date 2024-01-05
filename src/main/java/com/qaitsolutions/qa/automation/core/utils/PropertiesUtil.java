package com.qaitsolutions.qa.automation.core.utils;

import com.qaitsolutions.qa.automation.core.testng.Log;
import lombok.NonNull;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Entity handles the reading of properties files in a safe way.
 */
public class PropertiesUtil {

    /**
     * Reads a properties files and transforms it into a readable object.
     *
     * @param path path and filename of the properties file to be read.
     * @return {@link Properties} object with values from file. If file was not found an
     * empty object is returned.
     */
    public static Properties read(@NonNull final String path) {
        final var properties = new Properties();

        try (var input = new FileInputStream(path)) {
            properties.load(input);
        } catch (IOException e) {
            Log.warn("Failed to load properties file at location [" + path + "]", e);
        }

        return properties;
    }

    /**
     * Writes an {@link Properties} object to a properties file.
     *
     * @param properties values that need to be written to file
     * @param path       directory where to write the file
     * @param filename   filename of the new properties file
     */
    public static void write(
            @NonNull final Properties properties,
            @NonNull final String path,
            @NonNull final String filename) {

        var pathFilename = path + "/" + filename + ".properties";

        try {
            var actualPath = Paths.get(path + "/");
            Files.createDirectories(actualPath);

            var output = new FileOutputStream(pathFilename);

            properties.store(output, "");
        } catch (IOException e) {
            Log.warn("Failed to write properties file at location [" + pathFilename + "]", e);
        }
    }
}
