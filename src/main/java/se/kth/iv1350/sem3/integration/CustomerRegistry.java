package se.kth.iv1350.sem3.integration;
import se.kth.iv1350.sem3.model.Customer;
import java.util.ArrayList;

/**
 * A class for the programs customer registry.
 */
public class CustomerRegistry {
    private ArrayList<Customer> listOfCustomers;

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
    public void addCustomer(Customer newCustomer) {
        listOfCustomers.add(newCustomer);
    }

    /**
     * Finds a customer from the database.
     */
    public Customer findCustomer(String phoneNumber) {
        for (Customer currentCustomer : listOfCustomers) {
            if (currentCustomer.getPhoneNumber().equals(phoneNumber)) {
                return currentCustomer;
            }
        }
        return null;

    }

}
