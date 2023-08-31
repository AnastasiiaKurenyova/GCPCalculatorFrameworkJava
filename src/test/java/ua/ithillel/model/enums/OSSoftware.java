package ua.ithillel.model.enums;

public enum OSSoftware {
    FREE_DEBIAN("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)"),
    PAID_UBUNTU("Paid: Ubuntu Pro"),
    PAID_WINDOWS_SERVER("Paid: Windows Server 2012 R2, Windows Server 2016, Windows Server 2019, Windows Server (2004, 20H2)"),
    PAID_RED_HAT("Paid: Red Hat Enterprise Linux"),
    PAID_RED_HAT_SAP("Paid: Red Hat Enterprise Linux for SAP with HA and Update Services"),
    PAID_SLES("Paid: SLES"),
    PAID_SLES_12_SAP("Paid: SLES 12 for SAP"),
    PAID_SLES_15_SAP("Paid: SLES 15 for SAP"),
    PAID_SQL_STANDARD("Paid: SQL Server Standard (2012, 2014, 2016, 2017, 2019)"),
    PAID_SQL_WEB("Paid: SQL Server Web (2012, 2014, 2016, 2017, 2019)"),
    PAID_SQL_ENTERPRISE("Paid: SQL Server Enterprise (2012, 2014, 2016, 2017, 2019)");

    private String description;

    OSSoftware(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
