package se.kth.iv1350.sem3.model;

/**
 * Contains customer information transferred between layers.
 */
public class CustomerDTO {
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final BikeDTO bike;

    /**
     * The customer classes constructor.
     * 
     * @param name Customers name.
     * @param email Customers email.
     * @param phoneNumber Customers phone number.
     * @param bike Customers bike.
     */
    public CustomerDTO(String name, String email, String phoneNumber, BikeDTO bike) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bike = bike;
    }

    /**
     * Creates a copy of an existing customer.
     *
     * @param oldCustomer The customer to copy.
     */
    public CustomerDTO(CustomerDTO oldCustomer) {
        this.name = oldCustomer.getName();
        this.email = oldCustomer.getEmail();
        this.phoneNumber = oldCustomer.getPhoneNumber();
        this.bike = new BikeDTO(oldCustomer.getBike());
    }

    /**
     * A getter method that returns the customers name.
     * 
     * @return Returns customers name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * A getter method that returns the customers phone number.
     * 
     * @return Returns customers phone number.
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * A getter method that returns customers email.
     * 
     * @return Returns customers email.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * A getter method that returns a copy of customers bike.
     * 
     * @return Returns a copy of customers bike.
     */
    public BikeDTO getBike() {
        return new BikeDTO(bike);
    }
}
