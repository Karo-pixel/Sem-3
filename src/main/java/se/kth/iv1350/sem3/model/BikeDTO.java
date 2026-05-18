package se.kth.iv1350.sem3.model;

/**
 * Contains information about a customer's bike.
 */
public class BikeDTO {
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
    public BikeDTO(String bikeBrand, String bikeModel, String bikeSerialNo) {
        this.bikeBrand = bikeBrand;
        this.bikeModel = bikeModel;
        this.bikeSerialNo = bikeSerialNo;
    }

    public BikeDTO(BikeDTO oldBike) {
        this.bikeBrand = oldBike.getBikeBrand();
        this.bikeModel = oldBike.getBikeModel();
        this.bikeSerialNo = oldBike.getBikeSerialNo();
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
}
