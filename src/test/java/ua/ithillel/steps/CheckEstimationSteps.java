package ua.ithillel.steps;

import ua.ithillel.driver.DriverSingleton;
import ua.ithillel.pages.AbstractPage;
import ua.ithillel.pages.EstimationPage;
import ua.ithillel.pages.calculator.ComputeEngineCalcPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;


public class CheckEstimationSteps extends AbstractPage {

    public CheckEstimationSteps() {
        super(DriverSingleton.getDriver());
    }

    @And("^I click Add to Estimate button$")
    public void clickAddToEstimateButton() {
        new ComputeEngineCalcPage(driver).addToEstimate();
    }

    @Then("I should get the total estimated cost {double}$ on Estimation page with {}")
    public void iShouldGetTheTotalEstimatedCostTotalEstimatedCost$OnEstimationPageWithLastAddedModule(double expectedCost, String module) {
        double actualCost = new EstimationPage(driver).getTotalEstimationValue(module);
        Assertions.assertEquals(actualCost, expectedCost, "Total estimated cost value is not expected");
    }
}
