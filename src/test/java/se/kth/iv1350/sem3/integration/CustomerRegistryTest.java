package se.kth.iv1350.sem3.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.sem3.model.BikeDTO;
import se.kth.iv1350.sem3.model.CustomerDTO;

/**
 * Test class for CustomerRegistry.
 * 
 */
public class CustomerRegistryTest {
    private CustomerRegistry registry;
    private CustomerDTO customer;

    /**
     * Set up the test environment before each test.
     * 
     */
    @BeforeEach
    public void setUp() {
        registry = new CustomerRegistry();
        BikeDTO bike = new BikeDTO("Lexus", "Tiger", "55");
        customer = new CustomerDTO("Karo", "karosh@kth.se", "0704345829", bike);
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

        CustomerDTO actual = registry.findCustomer("0704345829");

        assertEquals(customer.getName(), actual.getName(), "Wrong customer name.");
        assertEquals(customer.getEmail(), actual.getEmail(), "Wrong customer email.");
        assertEquals(customer.getPhoneNumber(), actual.getPhoneNumber(), "Wrong customer phone number.");
    }

    /**
     * Tests that finding a missing customer returns null.
     */
    @Test
    public void testFindMissingCustomerReturnsNull() {
        CustomerDTO actual = registry.findCustomer("0000000000");

        assertNull(actual, "Expected missing customer search to return null.");
    }

    /**
     * Test to see if customer registry returns a copy of the customer and not the actual object.
     */
    @Test
    public void testFindCustomerReturnsCopy() {
        registry.addCustomer(customer);

        CustomerDTO actual = registry.findCustomer(customer.getPhoneNumber());

        assertNotSame(customer, actual, "Expected registry to return a copy of the customer, not the original object.");
    }

    /**
     * Test to see if customer registry has stored the customer by deep copying its information such as its bike.
     */
    @Test
    public void testFindCustomerReturnsCustomerWithCopiedBike() {
        registry.addCustomer(customer);

        CustomerDTO actual = registry.findCustomer(customer.getPhoneNumber());

        assertNotSame(customer.getBike(), actual.getBike(), "Expected returned customer to contain a copy of the bike.");
    }
}