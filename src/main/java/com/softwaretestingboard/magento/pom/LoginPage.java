package com.softwaretestingboard.magento.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends WebModel {

    public static final String STATIC_URL = "https://magento.softwaretestingboard.com/customer/account/login";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password){
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("send2")).click();
    }

}
