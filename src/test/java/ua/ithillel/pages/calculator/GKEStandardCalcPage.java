package ua.ithillel.pages.calculator;

import ua.ithillel.pages.AbstractPage;
import ua.ithillel.waiters.WaitersHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GKEStandardCalcPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//label[contains(text(),'Total number of nodes in Node Pool')]/following-sibling::input")
    private WebElement numberOfNodesInNodePool;

    @FindBy(xpath = "//*[@class='layout-align-end-start layout-row']/button")
    private WebElement addToEstimateButton;

    public GKEStandardCalcPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GKEStandardCalcPage setNodes(int nodes) {
        WaitersHelper.waitForVisibilityOf(driver,numberOfNodesInNodePool)
                .sendKeys(Integer.toString(nodes));
        WaitersHelper.waitForVisibilityOf(driver,addToEstimateButton);
        logger.info("Added " + nodes + " number of nodes in Node Pool");
        return this;
    }
}
