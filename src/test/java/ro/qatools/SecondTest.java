package ro.qatools;

import org.json.simple.JSONValue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import ro.qatools.pages.github.selenium.HomePage;
import ro.qatools.pages.github.selenium.IssuesPage;

import java.io.IOException;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static org.json.simple.JSONObject.toJSONString;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;
import static ro.qatools.utils.FileUtils.saveToDisk;

public class SecondTest extends BaseTest {

    @Test
    void testIssuesPage() {

        var homePage = new HomePage(driver);
        homePage.navigate().openIssuesTab();

        var issuesPage = new IssuesPage(driver);
        Map<String, Object> issueInfo = issuesPage.waitForUrl(Duration.ofSeconds(5))
                .search("sort:comments-desc")
                .filterByLabel("C-java")
                .clickOpenMenu()
                .getIssueRowInfo(0);

        System.out.println(JSONValue.toJSONString(issueInfo));
    }

}
