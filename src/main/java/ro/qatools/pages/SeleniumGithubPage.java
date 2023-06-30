package ro.qatools.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class SeleniumGithubPage {
    private WebDriver driver;
    static final String GITHUB_URL = "https://github.com/SeleniumHQ/selenium";

    private final By codeMenuButton = xpath("//get-repo//*[text()=\"Code\"]");
    private final By cloneUrlInput = xpath(
            "//*[@id=\"local-panel\"]//input[@type=\"text\"][contains(@value,\"https\")]");
    private final By releasesCount = xpath("//*[contains(text(), \"Releases\")]//span[@class=\"Counter\"]");


    public SeleniumGithubPage(WebDriver driver) {
        this.driver = driver;
    }

    public SeleniumGithubPage navigate(){
        driver.get(GITHUB_URL);
        return this;
    }

    public SeleniumGithubPage openCodeMenu(){
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

}
