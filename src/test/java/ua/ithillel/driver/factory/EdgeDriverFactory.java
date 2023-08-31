package ua.ithillel.driver.factory;

import ua.ithillel.driver.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverFactory implements WebDriverFactory {
    @Override
    public WebDriver getDriver(WebDriverType webDriverType) {
        return new EdgeDriver();
    }
}
