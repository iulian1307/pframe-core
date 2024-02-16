package com.qaitsolutions.pframe.core.utils;

import com.qaitsolutions.pframe.core.exceptions.FrameworkException;
import lombok.NonNull;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Class handles the reading of properties files in a safe way.
 * <p>
 * @author Iulian Andrei (iulian.andrei@qaitsolutions.com)
 * @since 1.0
 */
public final class PropertiesUtil {

    /**
     * Reads a properties files and transforms it into a readable object.
     * <p>
     * @param path path and filename of the properties file to be read.
     * @return {@link Properties} object with values from file. If file was not found an
     * empty object is returned.
     */
    public static Properties read(@NonNull final String path) {
        final var properties = new Properties();

        try (var input = new FileInputStream(path)) {
            properties.load(input);
        } catch (IOException e) {
            var message = String.format("Failed to load properties file at location [%s]", path);
            throw new FrameworkException(message, e);
        }

        return properties;
    }

    /**
     * Writes an {@link Properties} object to a properties file.
     * <p>
     * @param properties Values that need to be written to file.
     * @param path       Directory where to write the file.
     * @param filename   Filename of the new properties file.
     */
    public static void write(
            @NonNull final Properties properties,
            @NonNull final String path,
            @NonNull final String filename) {

        var pathFilename = path + "/" + filename + ".properties";

        try (var output = new FileOutputStream(pathFilename)) {
            var actualPath = Paths.get(path + "/");
            Files.createDirectories(actualPath);

            properties.store(output, "");
        } catch (IOException e) {
            var message = String.format("Failed to write properties file at location [%s]", pathFilename);
            throw new FrameworkException(message, e);
        }
    }
}
