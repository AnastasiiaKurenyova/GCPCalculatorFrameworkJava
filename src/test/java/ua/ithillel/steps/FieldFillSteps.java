package ua.ithillel.steps;

import ua.ithillel.driver.DriverSingleton;
import ua.ithillel.model.ComputeEngineData;
import ua.ithillel.model.ComputeEngineDataBuilder;
import ua.ithillel.model.enums.*;
import ua.ithillel.pages.AbstractPage;
import ua.ithillel.pages.calculator.ComputeEngineCalcPage;
import ua.ithillel.pages.calculator.GKEStandardCalcPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

import java.util.List;

public class FieldFillSteps extends AbstractPage {

    public FieldFillSteps() {
        super(DriverSingleton.getDriver());
    }

    @When("I fill Number of instances field with {int}")
    public void iFillNumberOfInstancesFieldWith(int instances){
        new ComputeEngineCalcPage(driver).setInstances(instances);
    }

    @When("I fill Total number of nodes in Node Pool field with {int}")
    public void iFillTotalNumberOfNodesInNodePoolFieldWith(int nodes) {
        new GKEStandardCalcPage(driver).setNodes(nodes);
    }

    @When("^I fill fields for Compute Engine service to proceed with parameters:$")
    public void iFillFieldsForComputeEngineServiceWithParameters(DataTable dataTable) {

        List<List<String>> computeEngineDataList = dataTable.asLists(String.class);

        ComputeEngineData computeEngineData = new ComputeEngineDataBuilder()
                .setInstances(Integer.parseInt(computeEngineDataList.get(1).get(0)))
                .setOsSoftware(OSSoftware.valueOf(computeEngineDataList.get(1).get(1)))
                .setProvisioningModel(ProvisioningModel.valueOf(computeEngineDataList.get(1).get(2)))
                .setMachineFamily(MachineFamily.valueOf(computeEngineDataList.get(1).get(3)))
                .setSeries(Series.valueOf(computeEngineDataList.get(1).get(4)))
                .setMachineType((computeEngineDataList.get(1).get(5)))
                .setBootDiskSize(Integer.parseInt((computeEngineDataList.get(1).get(6))))
                .createComputeEngineData();

        new ComputeEngineCalcPage(driver).setComputeEngineData(computeEngineData);

    }
}
