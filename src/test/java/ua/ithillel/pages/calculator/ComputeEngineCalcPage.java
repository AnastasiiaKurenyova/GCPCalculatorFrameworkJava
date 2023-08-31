package ua.ithillel.pages.calculator;

import ua.ithillel.model.ComputeEngineData;
import ua.ithillel.model.enums.*;
import ua.ithillel.pages.AbstractPage;
import ua.ithillel.pages.EstimationPage;
import ua.ithillel.waiters.WaitersHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputeEngineCalcPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//label[contains(text(),'Number of instances')]/following-sibling::input")
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = "//label[contains(text(),'Operating System')]/parent::md-input-container/md-select")
    private WebElement osSoftwareDropdown;

    @FindBy(xpath = "//label[contains(text(),'Provisioning model')]/parent::md-input-container/md-select")
    private WebElement provisioningModelDropdown;

    @FindBy(xpath = "//label[contains(text(),'Machine Family')]/parent::md-input-container/md-select")
    private WebElement machineFamilyDropdown;

    @FindBy(xpath = "//label[contains(text(),'Series')]/parent::md-input-container/md-select")
    private WebElement seriesDropdown;

    @FindBy(xpath = "//label[contains(text(),'Machine type')]/parent::md-input-container/md-select")
    private WebElement machineTypeDropdown;

    @FindBy(xpath = "//label[contains(text(),'Boot disk size')]/following-sibling::input")
    private WebElement bootDiskSizeInput;

    @FindBy(xpath = "//*[@class='layout-align-end-start layout-row']/button")
    private WebElement addToEstimateButton;

    public ComputeEngineCalcPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ComputeEngineCalcPage openPage() {
        driver.get("https://cloud.google.com/products/calculator");
        //driver.get(TestDataReader.getTestData(HOMEPAGE_URL));
        return this;
    }

    public ComputeEngineCalcPage switchToCalculatorFrame() {
        driver.switchTo().frame(0).switchTo().frame(0);
        return this;
    }

    public ComputeEngineCalcPage setComputeEngineData(ComputeEngineData computeEngineData) {
        setInstances(computeEngineData.getInstances());
        setOSSoftware(computeEngineData.getOsSoftware());
        setProvisioningModel(computeEngineData.getProvisioningModel());
        setMachineFamily(computeEngineData.getMachineFamily());
        setSeries(computeEngineData.getSeries());
        setMachineType(computeEngineData.getMachineType());
        setBootDiskSize(computeEngineData.getBootDiskSize());
        return this;
    }

    public ComputeEngineCalcPage setInstances(int instances) {
        WaitersHelper.waitForVisibilityOf(driver, numberOfInstancesInput)
                .sendKeys(Integer.toString(instances));
        WaitersHelper.waitForVisibilityOf(driver, addToEstimateButton);
        logger.info("Added [" + instances + "] instances to Number of Instances");
        return this;
    }

    public ComputeEngineCalcPage setOSSoftware(OSSoftware osSoftware) {
        WaitersHelper.waitForVisibilityOf(driver, osSoftwareDropdown).click();
        driver.findElement(By.xpath(getOptionLocator(osSoftware.getDescription()))).click();
        logger.info("Added [" + osSoftware.getDescription() + "] OS / Software");
        return this;
    }

    public ComputeEngineCalcPage setProvisioningModel(ProvisioningModel provisioningModel) {
        WaitersHelper.waitForVisibilityOf(driver, provisioningModelDropdown).click();
        driver.findElement(By.xpath(getOptionLocator(provisioningModel.getDescription()))).click();
        logger.info("Added [" + provisioningModel.getDescription() + "] Provisioning Model");
        return this;
    }

    public ComputeEngineCalcPage setMachineFamily(MachineFamily machineFamily) {
        WaitersHelper.waitForVisibilityOf(driver, machineFamilyDropdown).click();
        driver.findElement(By.xpath(getOptionLocator(machineFamily.getDescription()))).click();
        logger.info("Added [" + machineFamily.getDescription() + "] Machine Family");
        return this;
    }

    public ComputeEngineCalcPage setSeries(Series series) {
        WaitersHelper.waitForVisibilityOf(driver, seriesDropdown).click();
        driver.findElement(By.xpath(getOptionLocator(series.toString()))).click();
        logger.info("Added [" + series + "] Series");
        return this;
    }

    public ComputeEngineCalcPage setMachineType(String machineType) {
        WaitersHelper.waitForVisibilityOf(driver, machineTypeDropdown).click();
        WaitersHelper.waitForVisibilityOf(driver, driver.findElement(By.xpath(getOptionLocator(machineType)))).click();
        logger.info("Added [" + machineType + "] Machine Type");
        return this;
    }

    public ComputeEngineCalcPage setBootDiskSize(int bootDiskSize) {
        WaitersHelper.waitForVisibilityOf(driver, bootDiskSizeInput).sendKeys(Integer.toString(bootDiskSize));
        logger.info("Added [" + bootDiskSize + "] GiB Boot Disk Size");
        return this;
    }

    public EstimationPage addToEstimate() {
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        WaitersHelper.waitForVisibilityOf(driver, addToEstimateButton).click();
        // locator
        return new EstimationPage(driver);
    }

    private String getOptionLocator(String locator) {
        return "//md-option/div[contains(text(),'" + locator + "')]";
    }

}
