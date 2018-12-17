package uk.gov.dvla.identity.model;

public class Vehicle {

    private String regNumber;
    private String make;
    private String colour;

    public Vehicle(String regNumber, String make, String colour) {
        this.regNumber = regNumber;
        this.make = make;
        this.colour = colour;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getMake() {
        return make;
    }

    public String getColour() {
        return colour;
    }

}
