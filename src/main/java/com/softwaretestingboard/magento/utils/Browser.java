package com.softwaretestingboard.magento.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.String.format;

public class Browser {

    public WebDriver driver(){
        String browser = System.getProperty("browser");
        if (browser == null){
            browser = "chrome";
        }
        switch (browser.toLowerCase()){
            case "chrome": return chrome();
            case "firefox": return firefox();
            default: throw new Error(format("Browser \"%s\" is unsupported", browser));
        }
    }

    private WebDriver chrome(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver firefox(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

}

