package org.example;

public class Vehicle {
    private String vin;
    private String country;
    private String city;
    private String state;
    private String postalCode;
    private String modelYear;
    private String make;
    private String electricVehicleType;
    private String cafvEligibilityl;
    private String electricRange;
    private String baseMSPR;
    private String legislativeDistrict;
    private String DOLVehicleId;
    private String location;
    private String electricUtility;
    private String censusTract;

    public Vehicle(String vin, String country, String city, String state,
                   String postalCode, String modelYear, String make, String electricVehicleType,
                   String cafvEligibilityl, String electricRange, String baseMSPR, String legislativeDistrict,
                   String DOLVehicleId, String location, String electricUtility, String censusTract) {
        this.vin = vin;
        this.country = country;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.modelYear = modelYear;
        this.make = make;
        this.electricVehicleType = electricVehicleType;
        this.cafvEligibilityl = cafvEligibilityl;
        this.electricRange = electricRange;
        this.baseMSPR = baseMSPR;
        this.legislativeDistrict = legislativeDistrict;
        this.DOLVehicleId = DOLVehicleId;
        this.location = location;
        this.electricUtility = electricUtility;
        this.censusTract = censusTract;
    }

    public String getVin() {
        return vin;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getModelYear() {
        return modelYear;
    }

    public String getMake() {
        return make;
    }

    public String getElectricVehicleType() {
        return electricVehicleType;
    }

    public String getCafvEligibilityl() {
        return cafvEligibilityl;
    }

    public String getElectricRange() {
        return electricRange;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setElectricVehicleType(String electricVehicleType) {
        this.electricVehicleType = electricVehicleType;
    }

    public void setCafvEligibilityl(String cafvEligibilityl) {
        this.cafvEligibilityl = cafvEligibilityl;
    }

    public void setElectricRange(String electricRange) {
        this.electricRange = electricRange;
    }

    public void setBase(String baseMSPR) {
        this.baseMSPR = baseMSPR;
    }

    public String getBaseMSPR() {
        return baseMSPR;
    }

    public String getLegislativeDistrict() {
        return legislativeDistrict;
    }

    public String getDOLVehicleId() {
        return DOLVehicleId;
    }

    public String getLocation() {
        return location;
    }

    public String getElectricUtility() {
        return electricUtility;
    }

    public String getCensusTract() {
        return censusTract;
    }

    public void setBaseMSPR(String baseMSPR) {
        this.baseMSPR = baseMSPR;
    }

    public void setLegislativeDistrict(String legislativeDistrict) {
        this.legislativeDistrict = legislativeDistrict;
    }

    public void setDOLVehicleId(String DOLVehicleId) {
        this.DOLVehicleId = DOLVehicleId;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setElectricUtility(String electricUtility) {
        this.electricUtility = electricUtility;
    }

    public void setCensusTract(String censusTract) {
        this.censusTract = censusTract;
    }
}
