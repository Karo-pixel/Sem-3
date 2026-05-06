package se.kth.iv1350.sem3.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.sem3.model.Bike;
import se.kth.iv1350.sem3.model.Customer;

/**
 * Test class for CustomerRegistry.
 * 
 */
public class CustomerRegistryTest {
    private CustomerRegistry registry;
    private Customer customer;

    /**
     * Sets up the test environment before each test.
     * 
     */
    @BeforeEach
    public void setUp() {
        registry = new CustomerRegistry();
        Bike bike = new Bike("Lexus", "Tiger", "55");
        customer = new Customer("Karo", "karosh@kth.se", "0704345829", bike);
    }

    /**
     * Cleans up the test environment after each test.
     * 
     */
    @AfterEach
    public void tearDown() {
        registry = null;
        customer = null;
    }

    /**
     * Tests that finding an existing customer returns the added customer.
     */
    @Test
    public void testFindExistingCustomerReturnsAddedCustomer() {
        registry.addCustomer(customer);

        Customer actual = registry.findCustomer("0704345829");
        Customer expected = customer;

        assertSame(expected, actual, "Expected to find the added customer.");
    }

    /**
     * Tests that finding a missing customer returns null.
     */
    @Test
    public void testFindMissingCustomerReturnsNull() {
        Customer actual = registry.findCustomer("0000000000");

        assertNull(actual, "Expected missing customer search to return null.");
    }
}