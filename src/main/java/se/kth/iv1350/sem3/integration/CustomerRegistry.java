package se.kth.iv1350.sem3.integration;
import se.kth.iv1350.sem3.model.CustomerDTO;
import java.util.ArrayList;

/**
 * A class for the programs customer registry.
 */
public class CustomerRegistry {
    private ArrayList<CustomerDTO> listOfCustomers;

    /**
     * The classes constructor.
     */
    public CustomerRegistry() {
        listOfCustomers = new ArrayList<>();
    }

    /**
     * Adds a customer to the database.
     * 
     * @param newCustomer Is the new customer.
     */
    public void addCustomer(CustomerDTO newCustomer) {
        listOfCustomers.add(newCustomer);
    }

    /**
     * Finds a customer from the database.
     */
    public CustomerDTO findCustomer(String phoneNumber) {
        for (CustomerDTO currentCustomer : listOfCustomers) {
            if (currentCustomer.getPhoneNumber().equals(phoneNumber)) {
                return currentCustomer;
            }
        }
        return null;

    }

}
