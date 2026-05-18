package se.kth.iv1350.sem3.integration;
import se.kth.iv1350.sem3.model.CustomerDTO;
import java.util.ArrayList;

/**
 * Simulates a database that stores customers.
 */
public class CustomerRegistry {
    private ArrayList<CustomerDTO> listOfCustomers;

    /**
     * Creates an empty customer registry.
     */
    public CustomerRegistry() {
        listOfCustomers = new ArrayList<>();
    }

    /**
     * Adds a customer to the simulated database.
     *
     * @param newCustomer The customer to add.
     */
    public void addCustomer(CustomerDTO newCustomer) {
        listOfCustomers.add(new CustomerDTO(newCustomer));
    }

    /**
     * Searches for a customer by phone number.
     *
     * @param phoneNumber The phone number of the customer to find.
     * @return The matching customer, or {@code null} if no customer is found.
     */
    public CustomerDTO findCustomer(String phoneNumber) {
        for (CustomerDTO currentCustomer : listOfCustomers) {
            if (currentCustomer.getPhoneNumber().equals(phoneNumber)) {
                return new CustomerDTO(currentCustomer);
            }
        }
        return null;

    }

}
