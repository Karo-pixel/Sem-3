package se.kth.iv1350.sem3.model;

/**
 * A class for Customer data type.
 */
public class Customer {
    private String name;
    private String email;
    private String phoneNumber;
    private Bike bike;

    /**
     * The customer classes constructor.
     * 
     * @param name Customers name.
     * @param email Customers email.
     * @param phoneNumber Customers phone number.
     * @param bike Customers bike.
     */
    public Customer(String name, String email, String phoneNumber, Bike bike) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bike = bike;
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
     * A getter method that returns customers bike.
     * 
     * @return Returns customers bike.
     */
    public Bike getBike() {
        return this.bike;
    }
    
    /**
     * A method that returns customer infromation as strings.
     */
    @Override
    public String toString() {
        return "Customer name: " + this.name + "\n" +
               "Email: " + this.email + "\n" +
               "Phone number: " + this.phoneNumber + "\n";
    }
}
