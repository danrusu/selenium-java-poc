package ro.qatools.models;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SeleniumGithubInfo {
    private final String cloneUrl;
    private final int releaseCount;

    public SeleniumGithubInfo(String cloneUrl, int releaseCount) {
        this.cloneUrl = cloneUrl;
        this.releaseCount = releaseCount;
    }

    public void saveToDisk() throws IOException {
        Files.write(
                Path.of(System.getProperty("user.dir"), "selenium-meta-data.json"),
                this.toJson().getBytes(UTF_8)
        );
    }

    // for complex models you can use Jackson
    private java.lang.String toJson() {
        return "{ " +
                "\"url\" : \"" + this.cloneUrl + "\", " +
                "\"releaseCount\" : " + this.releaseCount +
                " }";
    }
}
