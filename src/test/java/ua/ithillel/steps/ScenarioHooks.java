package ua.ithillel.steps;

import ua.ithillel.driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ScenarioHooks {

    protected WebDriver driver;

    @Before
    public void beforeScenario() {
        driver = DriverSingleton.getDriver();
    }

    @After(order = 1)
    public void takeScreenshotOnFailure(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            String scenarioName = scenario.getName() + ".png";
            scenario.attach(ts.getScreenshotAs(OutputType.BYTES), "image/png", scenarioName);
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),
                    new File("target/screenshots/" + scenarioName));
        }
    }

    @After (order = 0)
    public void afterScenario() {
        DriverSingleton.closeDriver();
    }
}
