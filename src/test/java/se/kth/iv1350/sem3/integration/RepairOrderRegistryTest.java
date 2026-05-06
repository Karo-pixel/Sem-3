package se.kth.iv1350.sem3.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.sem3.model.Bike;
import se.kth.iv1350.sem3.model.Customer;
import se.kth.iv1350.sem3.model.RepairOrder;
import se.kth.iv1350.sem3.model.RepairTask;

/**
 * Test class for RepairOrderRegistry.
 * 
 */
public class RepairOrderRegistryTest {
    private RepairOrderRegistry registry;
    private Customer customer;
    private RepairOrder order;
    private RepairTask task;

    /**
     * Sets up the test environment before each test.
     * 
     * 
     */
    @BeforeEach
    public void setUp() {
        registry = new RepairOrderRegistry();
        Bike bike = new Bike("Lexus", "Tiger", "55");
        customer = new Customer("Karo", "karosh@kth.se", "0704345829", bike);
        order = new RepairOrder(customer, "2023-10-01", "Engine issue");
        task = new RepairTask("Oil Change", "Change engine oil", 50.0);
        registry.addRepairOrder(order);
    }

    /**
     * Cleans up the test environment after each test.
     * 
     */
    @AfterEach
    public void tearDown() {
        registry = null;
        customer = null;
        order = null;
        task = null;
    }

    /**
     * Tests that finding an existing repair order returns the added order.
     */
    @Test
    public void testFindExistingRepairOrderReturnsAddedOrder() {
        RepairOrder actual = registry.findRepairOrder(customer);
        assertSame(order, actual, "Expected to find the added repair order.");
    }

    /**
     * Tests that finding a missing repair order returns null.
     */
    @Test
    public void testFindMissingRepairOrderReturnsNull() {
        Bike bike = new Bike("Honda", "Civic", "22");
        Customer missingCustomer = new Customer("John", "john@example.com", "1234567890", bike);
        RepairOrder actual = registry.findRepairOrder(missingCustomer);
        assertNull(actual, "Expected missing repair order search to return null.");
    }

    /**
     * Tests adding a repair task to a repair order.
     */
    @Test
    public void testAddRepairTask() {
        registry.addRepairTask(order, task);
        String tasks = registry.getRepairTasks(order);
        assertTrue(tasks.contains("Oil Change"), "Expected repair task to be added.");
    }
}
