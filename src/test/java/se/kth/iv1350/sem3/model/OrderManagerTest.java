package se.kth.iv1350.sem3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.sem3.integration.RepairOrderRegistry;

/**
 * Test class for OrderManager.
 */
public class OrderManagerTest {
    private OrderManager manager;
    private RepairOrderRegistry repairOrderRegistry;
    private CustomerDTO customer;
    private RepairOrder repairOrder;

    /**
     * Sets up the test environment before each test.
     */
    @BeforeEach
    public void setUp() {
        repairOrderRegistry = new RepairOrderRegistry();
        manager = new OrderManager(repairOrderRegistry);

        BikeDTO bike = new BikeDTO("Lexus", "Tiger", "55");
        customer = new CustomerDTO("Karo", "karosh@kth.se", "0704345829", bike);
        repairOrder = manager.createRepairOrder(customer, "2026-04-10", "The brakes don't work.");
    }

    /**
     * Cleans up the test environment after each test.
     */
    @AfterEach
    public void tearDown() {
        manager = null;
        repairOrderRegistry = null;
        customer = null;
        repairOrder = null;
    }

    /**
     * Tests that creating a repair order returns a repair order connected to the correct customer.
     */
    @Test
    public void testCreateRepairOrderReturnsOrderWithCorrectCustomer() {
        CustomerDTO actual = repairOrder.getCustomer();
        CustomerDTO expected = customer;

        assertNotSame(expected, actual, "Expected a copy of the customer, not the original customer object.");
    
        assertEquals(expected.getName(), actual.getName(), "Wrong customer name.");
        assertEquals(expected.getEmail(), actual.getEmail(), "Wrong customer email.");
        assertEquals(expected.getPhoneNumber(), actual.getPhoneNumber(), "Wrong customer phone number.");
    }

    /**
     * Tests that a created repair order is stored in the repair order registry.
     */
    @Test
    public void testCreateRepairOrderStoresOrderInRegistry() {
        RepairOrder actual = repairOrderRegistry.findRepairOrder(customer);
        RepairOrder expected = repairOrder;

        assertNotSame(expected, actual, "Expected objects with different references.");

        assertEquals(expected.getCustomer().getName(), actual.getCustomer().getName(), "Expected the same customer names.");
        assertEquals(expected.getDate(), actual.getDate(), "Expected the same dates.");
        assertEquals(expected.getDiagReport(), actual.getDiagReport(), "Expected the same diagnostic reports.");
    }

    /**
     * Tests that creating a repair task adds its cost to the repair order total cost.
     */
    @Test
    public void testCreateRepairTaskAddsCostToTotalCost() {
        repairOrder = manager.createRepairTask(repairOrder, "Wheels", "Wheels are too old.", 70);
        repairOrder = manager.createRepairTask(repairOrder, "Brakes", "Brakes are damaged.", 20);

        double actual = repairOrder.getTotalCost();
        double expected = 90.0;

        assertEquals(expected, actual, "Expected total cost to include all created repair tasks.");
    }

    /**
     * Tests that accepting a repair order changes its state to accepted.
     */
    @Test
    public void testAcceptRepairOrderChangesStateToAccepted() {
        repairOrder = manager.acceptRepairOrder(repairOrder);

        boolean actual = repairOrder.getState();
        boolean expected = true;

        assertEquals(expected, actual, "Expected repair order state to be true after accepting.");
    }

    /**
     * Tests that rejecting a repair order changes its state to rejected.
     */
    @Test
    public void testRejectRepairOrderChangesStateToRejected() {
        repairOrder = manager.acceptRepairOrder(repairOrder);
        repairOrder = manager.rejectRepairOrder(repairOrder);

        boolean actual = repairOrder.getState();
        boolean expected = false;

        assertEquals(expected, actual, "Expected repair order state to be false after rejecting.");

    }

    /**
     * Tests that finding a repair order for a customer without an order returns null.
     */
    @Test
    public void testFindMissingRepairOrderReturnsNull() {
        BikeDTO bike = new BikeDTO("Trek", "Marlin", "99");
        CustomerDTO customerWithoutOrder = new CustomerDTO("Anna", "anna@kth.se", "0700000000", bike);

        RepairOrder actual = repairOrderRegistry.findRepairOrder(customerWithoutOrder);

        assertNull(actual, "Expected search for customer without repair order to return null.");
    }

    /**
     * Tests to see if the diagnostic report is correctly added to the repair order.
     */
    @Test
    public void testAddDiagnosticReportAddsCorrectReport() {
        repairOrder = manager.addDiagnosticReport(repairOrder, "Brakes need replacement.");

        assertEquals("Brakes need replacement.", repairOrder.getDiagReport(), "Expected diagnostic report to be added.");
    }

    /**
     * Tests to see if a repair task is correctly added to the repair order.
     */
    @Test
    public void testCreateRepairTaskAddsTaskToRepairOrder() {
        repairOrder = manager.createRepairTask(repairOrder, "Brakes", "Replace brake pads.", 20);

        assertEquals(1, repairOrder.getListOfTasks().size(), "Expected one repair task to be added.");
        assertEquals("Brakes", repairOrder.getListOfTasks().get(0).getName(), "Wrong repair task name.");
    }
}