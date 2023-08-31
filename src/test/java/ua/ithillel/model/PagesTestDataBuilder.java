package ua.ithillel.model;

import ua.ithillel.model.enums.MachineFamily;
import ua.ithillel.model.enums.OSSoftware;
import ua.ithillel.model.enums.ProvisioningModel;
import ua.ithillel.model.enums.Series;

public interface PagesTestDataBuilder {
    PagesTestDataBuilder setOsSoftware(OSSoftware osSoftware);

    PagesTestDataBuilder setProvisioningModel(ProvisioningModel provisioningModel);

    PagesTestDataBuilder setMachineFamily(MachineFamily machineFamily);

    PagesTestDataBuilder setSeries(Series series);

    PagesTestDataBuilder setMachineType(String machineType);

    PagesTestDataBuilder setBootDiskSize(int bootDiskSize);
}
