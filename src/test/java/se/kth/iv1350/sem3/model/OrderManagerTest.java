package se.kth.iv1350.sem3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.sem3.integration.CustomerRegistry;
import se.kth.iv1350.sem3.integration.RepairOrderRegistry;

/**
 * Test class for OrderManager.
 */
public class OrderManagerTest {
    private OrderManager manager;
    private CustomerRegistry customerRegistry;
    private RepairOrderRegistry repairOrderRegistry;
    private Customer customer;
    private RepairOrder repairOrder;

    /**
     * Sets up the test environment before each test.
     */
    @BeforeEach
    public void setUp() {
        customerRegistry = new CustomerRegistry();
        repairOrderRegistry = new RepairOrderRegistry();
        manager = new OrderManager(customerRegistry, repairOrderRegistry);

        Bike bike = new Bike("Lexus", "Tiger", "55");
        customer = new Customer("Karo", "karosh@kth.se", "0704345829", bike);
        repairOrder = manager.createRepairOrder(customer, "2026-04-10", "The brakes don't work.");
    }

    /**
     * Cleans up the test environment after each test.
     */
    @AfterEach
    public void tearDown() {
        manager = null;
        customerRegistry = null;
        repairOrderRegistry = null;
        customer = null;
        repairOrder = null;
    }

    /**
     * Tests that creating a repair order returns a repair order connected to the correct customer.
     */
    @Test
    public void testCreateRepairOrderReturnsOrderWithCorrectCustomer() {
        Customer actual = repairOrder.getCustomer();
        Customer expected = customer;

        assertSame(expected, actual, "Expected the repair order to belong to the specified customer.");
    }

    /**
     * Tests that a created repair order is stored in the repair order registry.
     */
    @Test
    public void testCreateRepairOrderStoresOrderInRegistry() {
        RepairOrder actual = repairOrderRegistry.findRepairOrder(customer);
        RepairOrder expected = repairOrder;

        assertSame(expected, actual, "Expected the created repair order to be stored in the registry.");
    }

    /**
     * Tests that creating a repair task adds its cost to the repair order total cost.
     */
    @Test
    public void testCreateRepairTaskAddsCostToTotalCost() {
        manager.createRepairTask(repairOrder, "Wheels", "Wheels are too old.", 70);
        manager.createRepairTask(repairOrder, "Brakes", "Brakes are damaged.", 20);

        double actual = repairOrder.getTotalCost();
        double expected = 90;

        assertEquals(expected, actual, "Expected total cost to include all created repair tasks.");
    }

    /**
     * Tests that accepting a repair order changes its state to accepted.
     */
    @Test
    public void testAcceptRepairOrderChangesStateToAccepted() {
        manager.acceptRepairOrder(repairOrder);

        String actual = repairOrder.toString();
        String expected = "The state of the order: true";

        boolean containsAcceptedState = actual.contains(expected);

        assertEquals(true, containsAcceptedState, "Expected repair order state to be true after accepting.");
    }

    /**
     * Tests that rejecting a repair order changes its state to rejected.
     */
    @Test
    public void testRejectRepairOrderChangesStateToRejected() {
        manager.acceptRepairOrder(repairOrder);
        manager.rejectRepairOrder(repairOrder);

        String actual = repairOrder.toString();
        String expected = "The state of the order: false";

        boolean containsRejectedState = actual.contains(expected);

        assertEquals(true, containsRejectedState, "Expected repair order state to be false after rejecting.");

    }

    /**
     * Tests that finding a repair order for a customer without an order returns null.
     */
    @Test
    public void testFindMissingRepairOrderReturnsNull() {
        Bike bike = new Bike("Trek", "Marlin", "99");
        Customer customerWithoutOrder = new Customer("Anna", "anna@kth.se", "0700000000", bike);

        RepairOrder actual = repairOrderRegistry.findRepairOrder(customerWithoutOrder);

        assertNull(actual, "Expected search for customer without repair order to return null.");
    }
}