package ro.qatools.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumGithubPage {
    private WebDriver driver;
    static final String GITHUB_URL = "https://github.com/SeleniumHQ/selenium";

    public SeleniumGithubPage(WebDriver driver) {
        this.driver = driver;
    }

    public SeleniumGithubPage navigate(){
        driver.get(GITHUB_URL);
        return this;
    }

    public SeleniumGithubPage openCloneMenu(){
        driver.findElement(By.xpath("//get-repo//*[text()=\"Code\"]")).click();
        return this;
    }

    public String getCloneUrl() {
        return driver
                .findElement(By.xpath("//*[@id=\"local-panel\"]//input[@type=\"text\"][contains(@value,\"https\")]"))
                .getAttribute("value");
    }

    public String getReleasesCount() {
        return driver
                .findElement(By.xpath("//*[contains(text(), \"Releases\")]//span[@class=\"Counter\"]"))
                .getText();
    }

}
