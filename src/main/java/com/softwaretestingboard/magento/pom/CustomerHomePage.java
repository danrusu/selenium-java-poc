package com.softwaretestingboard.magento.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class CustomerHomePage extends WebModel {

    public static final String URL = "https://magento.softwaretestingboard.com/";

    public CustomerHomePage(WebDriver driver) {
        super(driver);
    }

    public void waitForWelcomeMessage(Duration duration, String expectedMessage) {
        explicitWait(duration).until(textToBePresentInElementLocated(
                    By.className("logged-in"),
                    expectedMessage
                )
        );
    }
}
