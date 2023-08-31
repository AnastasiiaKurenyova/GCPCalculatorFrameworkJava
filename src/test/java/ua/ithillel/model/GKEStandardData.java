package ua.ithillel.model;

import ua.ithillel.model.enums.MachineFamily;
import ua.ithillel.model.enums.OSSoftware;
import ua.ithillel.model.enums.ProvisioningModel;
import ua.ithillel.model.enums.Series;

public class GKEStandardData implements PagesTestDataBuilder{

    private int nodes;
    private OSSoftware osSoftware;
    private ProvisioningModel provisioningModel;
    private MachineFamily machineFamily;
    private Series series;
    private String machineType;
    private int bootDiskSize;

    public GKEStandardData(int nodes, OSSoftware osSoftware, ProvisioningModel provisioningModel, MachineFamily machineFamily, Series series, String machineType, int bootDiskSize) {
        this.nodes = nodes;
        this.osSoftware = osSoftware;
        this.provisioningModel = provisioningModel;
        this.machineFamily = machineFamily;
        this.series = series;
        this.machineType = machineType;
        this.bootDiskSize = bootDiskSize;
    }

    public int getNodes() {
        return nodes;
    }

    public void setNodes(int nodes) {
        this.nodes = nodes;
    }

    public OSSoftware getOsSoftware() {
        return osSoftware;
    }

    public ProvisioningModel getProvisioningModel() {
        return provisioningModel;
    }

    public MachineFamily getMachineFamily() {
        return machineFamily;
    }

    public Series getSeries() {
        return series;
    }

    public String getMachineType() {
        return machineType;
    }

    public int getBootDiskSize() {
        return bootDiskSize;
    }

    @Override
    public PagesTestDataBuilder setOsSoftware(OSSoftware osSoftware) {
        return null;
    }

    @Override
    public PagesTestDataBuilder setProvisioningModel(ProvisioningModel provisioningModel) {
        return null;
    }

    @Override
    public PagesTestDataBuilder setMachineFamily(MachineFamily machineFamily) {
        return null;
    }

    @Override
    public PagesTestDataBuilder setSeries(Series series) {
        return null;
    }

    @Override
    public PagesTestDataBuilder setMachineType(String machineType) {
        return null;
    }

    @Override
    public PagesTestDataBuilder setBootDiskSize(int bootDiskSize) {
        return null;
    }
}

