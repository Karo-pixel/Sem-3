package se.kth.iv1350.sem3.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.fail;

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
    public void testFindExistingCustomerReturnsAddedCustomer() throws CustomerNotFoundException {
        registry.addCustomer(customer);

        CustomerDTO actual = registry.findCustomer("0704345829");

        assertEquals(customer.getName(), actual.getName(), "Wrong customer name.");
        assertEquals(customer.getEmail(), actual.getEmail(), "Wrong customer email.");
        assertEquals(customer.getPhoneNumber(), actual.getPhoneNumber(), "Wrong customer phone number.");
    }

    /**
     * Tests that finding a missing customer throws CustomerNotFoundException.
     */
    @Test
    public void testFindMissingCustomerThrowsCustomerNotFoundException() {
        try {
            registry.findCustomer("0000000000");
            fail("Expected CustomerNotFoundException to be thrown.");
        } catch (CustomerNotFoundException e) {
            assertEquals("No customer with phone number 0000000000 was found.", e.getMessage(), "Wrong exception message.");
        }
    }

    /**
     * Test to see if customer registry returns a copy of the customer and not the actual object.
     */
    @Test
    public void testFindCustomerReturnsCopy() throws CustomerNotFoundException {
        registry.addCustomer(customer);

        CustomerDTO actual = registry.findCustomer(customer.getPhoneNumber());

        assertNotSame(customer, actual, "Expected registry to return a copy of the customer, not the original object.");
    }

    /**
     * Test to see if customer registry has stored the customer by deep copying its information such as its bike.
     */
    @Test
    public void testFindCustomerReturnsCustomerWithCopiedBike() throws CustomerNotFoundException {
        registry.addCustomer(customer);

        CustomerDTO actual = registry.findCustomer(customer.getPhoneNumber());

        assertNotSame(customer.getBike(), actual.getBike(), "Expected returned customer to contain a copy of the bike.");
    }

    /**
     * Tests that the hardcoded database failure phone number throws DatabaseFailureException.
     */
    @Test
    public void testFindCustomerThrowsDatabaseFailureException() {
        try {
            registry.findCustomer("000");
            fail("Expected DatabaseFailureException to be thrown.");
        } catch (DatabaseFailureException e) {
            assertEquals("Could not call the customer database.", e.getMessage(), "Wrong exception message.");
        } catch (CustomerNotFoundException e) {
            fail("Expected DatabaseFailureException, but CustomerNotFoundException was thrown.");
        }
    }
}