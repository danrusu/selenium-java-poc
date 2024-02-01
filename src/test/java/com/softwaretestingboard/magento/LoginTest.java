package com.softwaretestingboard.magento;

import com.softwaretestingboard.magento.pom.CustomerHomePage;
import com.softwaretestingboard.magento.pom.HomePage;
import com.softwaretestingboard.magento.pom.LoginPage;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void test() {
        driver.get(HomePage.URL);
        HomePage homePage = new HomePage(driver);
        homePage.signIn();
        homePage.waitForUrlToContain(Duration.ofSeconds(5), LoginPage.STATIC_URL);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john.doe@yahoo.com", "Passw0rd");
        loginPage.waitForUrl(Duration.ofSeconds(5), CustomerHomePage.URL);

        CustomerHomePage customerHomePagePage = new CustomerHomePage(driver);
        customerHomePagePage.waitForWelcomeMessage(
                Duration.ofSeconds(5),
                "Welcome, John Doe!");
    }
}