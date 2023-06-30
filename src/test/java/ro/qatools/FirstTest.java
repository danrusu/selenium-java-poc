package ro.qatools;

import org.junit.jupiter.api.Test;
import ro.qatools.pages.github.selenium.HomePage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static org.json.simple.JSONObject.toJSONString;
import static ro.qatools.utils.FileUtils.saveToDisk;

public class FirstTest extends BaseTest {

    @Test
    void testSeleniumIUrlAndReleaseCount() throws IOException {
        var homePage = new HomePage(driver);

        homePage.navigate().openCodeMenu();
        var cloneUrl = homePage.getCloneUrl();
        var releasesCount = homePage.getReleasesCount();

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
