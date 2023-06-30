package ro.qatools.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserGetter {

    public WebDriver getChrome(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    public WebDriver getFirefox(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getDriver(){
        String browser = System.getProperty("browser");
        switch (browser){
            case "chrome": return getChrome();
            case "firefox": return getFirefox();
            default: throw new Error("Browser " + browser + " is unsupported");
        }

    }

}

