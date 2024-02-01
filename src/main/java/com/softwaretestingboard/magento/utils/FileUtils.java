package com.softwaretestingboard.magento.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileUtils {
    public static void saveToDisk(Path path, String json) throws IOException {
        Files.write(path, json.getBytes(UTF_8));
    }

}
