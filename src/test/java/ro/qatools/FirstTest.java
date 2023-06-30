package ro.qatools;

import org.junit.jupiter.api.*;
import ro.qatools.models.SeleniumGithubInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ro.qatools.utils.BrowserGetter;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTest {
    private WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new BrowserGetter().getDriver();
    }

    @AfterEach
    void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    void testSeleniumIUrlAndReleaseCount() throws IOException {
        final String githubUrl = "https://github.com/SeleniumHQ/selenium";
        driver.get(githubUrl);
        driver.findElement(By.xpath("//get-repo//*[text()=\"Code\"]")).click();
        String cloneUrl = driver
                .findElement(By.xpath("//*[@id=\"local-panel\"]//input[@type=\"text\"][contains(@value,\"https\")]"))
                .getAttribute("value");


        String releasesCount = driver
                .findElement(By.xpath("//*[contains(text(), \"Releases\")]//span[@class=\"Counter\"]"))
                .getText();


        new SeleniumGithubInfo(cloneUrl, Integer.parseInt(releasesCount)).saveToDisk();

    }

}
