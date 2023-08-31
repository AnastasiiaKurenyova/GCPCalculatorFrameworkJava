package ua.ithillel.model;

import ua.ithillel.model.enums.MachineFamily;
import ua.ithillel.model.enums.OSSoftware;
import ua.ithillel.model.enums.ProvisioningModel;
import ua.ithillel.model.enums.Series;

public class ComputeEngineData {
    private int instances;
    private OSSoftware osSoftware;
    private ProvisioningModel provisioningModel;
    private MachineFamily machineFamily;
    private Series series;
    private String machineType;
    private int bootDiskSize;

    public ComputeEngineData() {
    }

    public ComputeEngineData(int instances, OSSoftware osSoftware, ProvisioningModel provisioningModel, MachineFamily machineFamily, Series series, String machineType, int bootDiskSize) {
        this.instances = instances;
        this.osSoftware = osSoftware;
        this.provisioningModel = provisioningModel;
        this.machineFamily = machineFamily;
        this.series = series;
        this.machineType = machineType;
        this.bootDiskSize = bootDiskSize;
    }

    public int getInstances() {
        return instances;
    }

    public void setInstances(int instances) {
        this.instances = instances;
    }

    public OSSoftware getOsSoftware() {
        return osSoftware;
    }

    public void setOsSoftware(OSSoftware osSoftware) {
        this.osSoftware = osSoftware;
    }

    public ProvisioningModel getProvisioningModel() {
        return provisioningModel;
    }

    public void setProvisioningModel(ProvisioningModel provisioningModel) {
        this.provisioningModel = provisioningModel;
    }

    public MachineFamily getMachineFamily() {
        return machineFamily;
    }

    public void setMachineFamily(MachineFamily machineFamily) {
        this.machineFamily = machineFamily;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public int getBootDiskSize() {
        return bootDiskSize;
    }

    public void setBootDiskSize(int bootDiskSize) {
        this.bootDiskSize = bootDiskSize;
    }
}
