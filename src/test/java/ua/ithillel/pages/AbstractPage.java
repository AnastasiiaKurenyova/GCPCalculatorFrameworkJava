package ua.ithillel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AbstractPage {

    protected WebDriver driver;
    protected static final String HOMEPAGE_URL = "testdata.goodlecloud.url";

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

}
