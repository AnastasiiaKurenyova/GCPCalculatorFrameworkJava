package ua.ithillel.model;

import ua.ithillel.model.enums.MachineFamily;
import ua.ithillel.model.enums.OSSoftware;
import ua.ithillel.model.enums.ProvisioningModel;
import ua.ithillel.model.enums.Series;

public class ComputeEngineDataBuilder implements PagesTestDataBuilder {
    private int instances;
    private OSSoftware osSoftware;
    private ProvisioningModel provisioningModel;
    private MachineFamily machineFamily;
    private Series series;
    private String machineType;
    private int bootDiskSize;

    public ComputeEngineDataBuilder setInstances(int instances) {
        this.instances = instances;
        return this;
    }

    @Override
    public ComputeEngineDataBuilder setOsSoftware(OSSoftware osSoftware) {
        this.osSoftware = osSoftware;
        return this;
    }

    @Override
    public ComputeEngineDataBuilder setProvisioningModel(ProvisioningModel provisioningModel) {
        this.provisioningModel = provisioningModel;
        return this;
    }

    @Override
    public ComputeEngineDataBuilder setMachineFamily(MachineFamily machineFamily) {
        this.machineFamily = machineFamily;
        return this;
    }

    @Override
    public ComputeEngineDataBuilder setSeries(Series series) {
        this.series = series;
        return this;
    }

    @Override
    public ComputeEngineDataBuilder setMachineType(String machineType) {
        this.machineType = machineType;
        return this;
    }

    @Override
    public ComputeEngineDataBuilder setBootDiskSize(int bootDiskSize) {
        this.bootDiskSize = bootDiskSize;
        return this;
    }

    public ComputeEngineData createComputeEngineData() {
        return new ComputeEngineData(instances, osSoftware, provisioningModel, machineFamily, series, machineType, bootDiskSize);
    }
}