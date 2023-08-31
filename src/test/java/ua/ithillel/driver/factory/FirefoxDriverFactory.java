package ua.ithillel.driver.factory;

import ua.ithillel.driver.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverFactory implements WebDriverFactory {
    @Override
    public WebDriver getDriver(WebDriverType webDriverType) {
        return new FirefoxDriver();
    }
}
