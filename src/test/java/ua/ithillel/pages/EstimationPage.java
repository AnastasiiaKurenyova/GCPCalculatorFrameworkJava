package ua.ithillel.pages;

import ua.ithillel.waiters.WaitersHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EstimationPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    //@FindBy(xpath = "//*[@class='cartsection ng-scope _md']/following-sibling::div/h2/b")
    @FindBy(xpath = "//*[@class='cpc-cart-total']/h2/b")
    private WebElement totalCostEstimationLabelComputeEngine;

    @FindBy(xpath = "//*[@class='md-toolbar-tools']/*[contains(text(), 'GKE Standard Node')]/ancestor::*[@class='cartsection ng-scope _md']/following-sibling::div/h2/b")
    private WebElement totalCostEstimationLabelGKEStandard;

    public EstimationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public double getTotalEstimationValue(String module) {
        if (module.equals("Compute Engine")) {
            return getTotalEstimationValue(totalCostEstimationLabelComputeEngine);
        } else if (module.equals("GKE Standard")) {
            return getTotalEstimationValue(totalCostEstimationLabelGKEStandard);
        } else
            return 0;
    }

    private double getTotalEstimationValue(WebElement element) {

        WaitersHelper.waitForVisibilityOf(driver, element);

        double result = -1;
        Pattern pattern = Pattern.compile("[\\d]+.[\\d]+");
        Matcher matcher = pattern.matcher(element.getText());

        if (matcher.find()) {
            result = Double.parseDouble(matcher.group());
        }
        return result;
    }

}
