package ro.qatools;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import ro.qatools.utils.Browser;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new Browser().driver();
    }

    @AfterEach
    void tearDown() {
        driver.close();
        driver.quit();
    }
}
