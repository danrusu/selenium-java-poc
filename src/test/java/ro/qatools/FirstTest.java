package ro.qatools;

import org.junit.jupiter.api.Test;
import ro.qatools.pages.SeleniumGithubPage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static org.json.simple.JSONObject.toJSONString;
import static ro.qatools.utils.FileUtils.saveToDisk;

public class FirstTest extends BaseTest {

    @Test
    void testSeleniumIUrlAndReleaseCount() throws IOException {
        var seleniumGithubPage = new SeleniumGithubPage(driver);

        seleniumGithubPage.navigate().openCodeMenu();
        var cloneUrl = seleniumGithubPage.getCloneUrl();
        var releasesCount = seleniumGithubPage.getReleasesCount();

        String jsonInfo = toJSONString(Map.of(
                "cloneUrl", cloneUrl,
                "releasesCount", parseInt(releasesCount))
        ).replace("\\", "");

        saveToDisk(
                Path.of(
                        System.getProperty("user.dir"),
                        "selenium-meta-data.json"
                ),
                jsonInfo
        );

    }

}
