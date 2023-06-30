package ro.qatools;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ro.qatools.pages.SeleniumGithubPage;

import java.io.IOException;
import java.nio.file.Path;

import static ro.qatools.utils.FileUtils.saveToDisk;

public class FirstTest extends BaseTest {

    @Test
    void testSeleniumIUrlAndReleaseCount() throws IOException {
        var seleniumGithubPage = new SeleniumGithubPage(driver);

        seleniumGithubPage.navigate().openCloneMenu();
        var cloneUrl = seleniumGithubPage.getCloneUrl();
        var releasesCount = seleniumGithubPage.getReleasesCount();

        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("cloneUrl", cloneUrl);
        jsonInfo.put("releasesCount", Integer.parseInt(releasesCount));

        saveToDisk(
                Path.of(
                        System.getProperty("user.dir"),
                        "selenium-meta-data.json"
                ),
                jsonInfo
        );

    }

}
