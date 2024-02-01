package com.softwaretestingboard.magento.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends WebModel {

    public static final String URL = "https://magento.softwaretestingboard.com";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void signIn(){
        driver.findElement(By.linkText("Sign In")).click();
    }
}
