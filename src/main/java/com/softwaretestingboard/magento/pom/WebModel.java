package com.softwaretestingboard.magento.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

public class WebModel {
    protected final WebDriver driver;

    public WebModel(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForUrl(Duration duration, String expectedUrl) {
        new WebDriverWait(driver, duration).until(urlToBe(expectedUrl));
    }

    public void waitForUrlToContain(Duration duration, String expectedUrlPartialText) {
        new WebDriverWait(driver, duration).until(urlContains(expectedUrlPartialText));
    }

    public WebDriverWait explicitWait(Duration duration){
        return new WebDriverWait(driver, duration);
    }
}
