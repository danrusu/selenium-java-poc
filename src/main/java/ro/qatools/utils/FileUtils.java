package ro.qatools.utils;

import org.json.simple.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileUtils {
    public static void saveToDisk(Path path, JSONObject json) throws IOException {
        Files.write(path, json.toString().replace("\\", "").getBytes(UTF_8));
    }

}
