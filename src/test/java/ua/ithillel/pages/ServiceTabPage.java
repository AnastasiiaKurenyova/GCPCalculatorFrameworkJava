package ua.ithillel.pages;

import ua.ithillel.pages.calculator.ComputeEngineCalcPage;
import ua.ithillel.waiters.WaitersHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceTabPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
    private WebElement computeEngineButton;

    @FindBy(xpath = "//md-tab-item/div[@title='GKE Standard Node Pool (Kubernetes Engine)']")
    private WebElement gkeStandardButton;

    @FindBy(xpath = "//md-tab-item/div[@title='Backup for GKE']")
    private WebElement backupForGKEButton;

    public ServiceTabPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ComputeEngineCalcPage switchToComputeEngineTab() {
        scrollToServiceTab();
        WaitersHelper.waitForVisibilityOf(driver,computeEngineButton).click();
        return new ComputeEngineCalcPage(driver);
    }

    public ComputeEngineCalcPage switchToGKEStandardTab() {
        scrollToServiceTab();
        WaitersHelper.waitForVisibilityOf(driver,gkeStandardButton).click();
        return new ComputeEngineCalcPage(driver);
    }

    private void scrollToServiceTab() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementsByClassName('main-content layout-padding ng-scope _md layout-column')[0].scrollIntoView();");
    }
}
