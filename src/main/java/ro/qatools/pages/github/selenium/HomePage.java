package ro.qatools.pages.github.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

public class HomePage {
    private WebDriver driver;
    public static final String URL = "https://github.com/SeleniumHQ/selenium";

    private final By codeMenuButton = xpath("//get-repo//*[text()=\"Code\"]");
    private final By cloneUrlInput = xpath(
            "//*[@id=\"local-panel\"]//input[@type=\"text\"][contains(@value,\"https\")]");
    private final By releasesCount = xpath("//*[contains(text(), \"Releases\")]//span[@class=\"Counter\"]");
    private final By issuesTabButton = id("issues-tab");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage navigate(){
        driver.get(URL);
        return this;
    }

    public HomePage openCodeMenu(){
        driver.findElement(codeMenuButton).click();
        return this;
    }

    public String getCloneUrl() {
        return driver.findElement(cloneUrlInput)
                .getAttribute("value")
                .trim();
    }

    public String getReleasesCount() {
        return driver.findElement(releasesCount)
                .getText()
                .trim();
    }

    public void openIssuesTab(){
        driver.findElement(issuesTabButton).click();
    }

}
