package ua.ithillel.driver;

import ua.ithillel.driver.factory.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            LocalWebDriverFactory localWebDriverFactory = new LocalWebDriverFactory();
            //driver = localWebDriverFactory.getDriver(WebDriverType.valueOf(System.getProperty("browser").toUpperCase()));
            driver = localWebDriverFactory.getDriver(WebDriverType.CHROME);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

}

