package ua.ithillel.driver.factory;

import org.openqa.selenium.chrome.ChromeOptions;
import ua.ithillel.driver.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFactory implements WebDriverFactory {
    @Override
    public WebDriver getDriver(WebDriverType webDriverType) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("114.0.5735.90");
        return new ChromeDriver(chromeOptions);
    }
}
