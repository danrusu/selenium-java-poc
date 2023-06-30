package ro.qatools.pages.github.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

public class IssuesPage {
    private WebDriver driver;
    public static final String URL = "https://github.com/SeleniumHQ/selenium/issues";
    private final By searchInput = id("js-issues-search");
    private final By labelFilter = cssSelector("#js-issues-toolbar [title=Label]");
    private final By labelFilterInput = id("label-filter-field");
    private final By openMenu = xpath("//*[@id=\"js-issues-toolbar\"]//a[contains(@href,\"open\")]");

    private final By issueRow = cssSelector("[id^=issue_][class*=-row]");
    private final By issueTitle = cssSelector("[id^=issue_][id$=_link]");
    private final By issueLabel = cssSelector("[id^=label]");


    public IssuesPage(WebDriver driver) {
        this.driver = driver;
    }

    public IssuesPage navigate(){
        driver.get(URL);
        return this;
    }

    public IssuesPage waitForUrl(Duration duration) {
        new WebDriverWait(driver, duration).until(urlToBe(URL));
        return this;
    }

    public IssuesPage search(String text){
        var searchElement = driver.findElement(searchInput);
        searchElement.clear();
        searchElement.sendKeys(text);
        searchElement.sendKeys(ENTER);
        return this;
    }

    public IssuesPage filterByLabel(String label) {
        var labelFilterElement = driver.findElement(labelFilter);
        labelFilterElement.click();
        labelFilterElement.sendKeys(label);
        labelFilterElement.sendKeys(ENTER);
        return this;
    }

    public IssuesPage clickOpenMenu(){
        driver.findElement(openMenu).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(attributeContains(openMenu, "class", "selected"));
        return this;
    }

    public Map<String, Object> getIssueRowInfo(int index){
        WebElement issueRowElement = driver.findElements(issueRow).get(index);
        String issueRowTitle = driver.findElements(issueTitle).get(index).getText();
        List<String> issueLabels = issueRowElement
                .findElements(issueLabel)
                .stream()
                .map(WebElement::getText)
                .toList();
        return Map.of(
                "title", issueRowTitle,
                "labels", issueLabels
        );
    }
}
