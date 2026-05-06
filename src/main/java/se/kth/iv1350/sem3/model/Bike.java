package se.kth.iv1350.sem3.model;
/**
 * A class for Bike data type.
 */

public class Bike {
    private String bikeBrand;
    private String bikeModel;
    private String bikeSerialNo;

    /**
     * The Bike classes constructor.
     * 
     * @param bikeBrand The bikes brand.
     * @param bikeModel The bikes model.
     * @param bikeSerialNo The bikes serial number.
     */
    public Bike(String bikeBrand, String bikeModel, String bikeSerialNo) {
        this.bikeBrand = bikeBrand;
        this.bikeModel = bikeModel;
        this.bikeSerialNo = bikeSerialNo;
    }

    /**
     * A getter method that return the bikes brand.
     * 
     * @return Returns the bikes brand.
     */
    public String getBikeBrand() {
        return this.bikeBrand;
    }

    /**
     * A getter method that returns the bikes model.
     * 
     * @return Returns the bikes model.
     */
    public String getBikeModel() {
        return this.bikeModel;
    }

    /**
     * A getter method that returns the bikes serial number.
     * 
     * @return Returns the bikes serial number.
     */
    public String getBikeSerialNo() {
        return this.bikeSerialNo;
    }

    /**
     * A method that prints out the bike information.
     */
    @Override
    public String toString() {
        return "Bike brand: " + this.bikeBrand + "\n" +
               "Bike model: " + this.bikeModel + "\n" +
               "Bike Serial Number: " + this.bikeSerialNo + "\n";
    }

}
