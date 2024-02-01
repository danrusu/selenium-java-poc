package com.softwaretestingboard.magento.pom;

import org.openqa.selenium.WebDriver;

public class CustomerAccountPage extends WebModel {

    public static final String URL = "https://magento.softwaretestingboard.com/customer/account/";

    public CustomerAccountPage(WebDriver driver) {
        super(driver);
    }
}
