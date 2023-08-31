package ua.ithillel.steps;

import ua.ithillel.driver.DriverSingleton;
import ua.ithillel.pages.AbstractPage;
import ua.ithillel.pages.ServiceTabPage;
import ua.ithillel.pages.calculator.ComputeEngineCalcPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class NavigationSteps extends AbstractPage {

    public NavigationSteps() {
        super(DriverSingleton.getDriver());
    }

    @Given("^I navigated to GCP Calculator page$")
    public void iNavigateToGCPCalculator(){
        new ComputeEngineCalcPage(driver).openPage();
        new ComputeEngineCalcPage(driver).switchToCalculatorFrame();
    }

    @Given("^Compute Engine service is checked on Service Tab$")
    public void iCheckComputeEngine(){
        new ServiceTabPage(driver).switchToComputeEngineTab();
    }

    @Given("^GKE Standard service is checked on Service Tab$")
    @And("^I navigate to GKE Standard service on Service Tab$")
    public void gkeStandardServiceIsCheckedOnServiceTab() {
        new ServiceTabPage(driver).switchToGKEStandardTab();
    }

}
