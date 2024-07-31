public class Vehicle {
    private int policyNo;
    private String vehicleNo;
    private String vehicleType;
    private String customerName;
    private int engineNo;
    private int chassisNo;
    private long phoneNo;
    private String insuranceType;
    private double premiumAmt;
    private String fromDate;
    private String toDate;
    private int underWriterId;

    public Vehicle(int policyNo, String vehicleNo, String vehicleType, String customerName, int engineNo, int chassisNo,
                   long phoneNo, String insuranceType, double premiumAmt, String fromDate, String toDate, int underWriterId) {
        this.policyNo = policyNo;
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.customerName = customerName;
        this.engineNo = engineNo;
        this.chassisNo = chassisNo;
        this.phoneNo = phoneNo;
        this.insuranceType = insuranceType;
        this.premiumAmt = premiumAmt;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.underWriterId = underWriterId;
    }

    public int getPolicyNo() {
        return policyNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getEngineNo() {
        return engineNo;
    }

    public int getChassisNo() {
        return chassisNo;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public double getPremiumAmt() {
        return premiumAmt;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public int getUnderWriterId() {
        return underWriterId;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "policyNo=" + policyNo +
                ", vehicleNo='" + vehicleNo + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", customerName='" + customerName + '\'' +
                ", engineNo=" + engineNo +
                ", chassisNo=" + chassisNo +
                ", phoneNo=" + phoneNo +
                ", insuranceType='" + insuranceType + '\'' +
                ", premiumAmt=" + premiumAmt +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", underWriterId=" + underWriterId +
                '}';
    }
}
