package ua.ithillel.driver.factory;

import ua.ithillel.driver.WebDriverType;
import org.openqa.selenium.WebDriver;

public interface WebDriverFactory {

    WebDriver getDriver(WebDriverType webDriverType);
}
