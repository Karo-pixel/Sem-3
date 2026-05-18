package se.kth.iv1350.sem3.control;
import se.kth.iv1350.sem3.integration.Printer;
import se.kth.iv1350.sem3.integration.CustomerRegistry;
import se.kth.iv1350.sem3.integration.RepairOrderRegistry;
import se.kth.iv1350.sem3.model.CustomerDTO;
import se.kth.iv1350.sem3.model.OrderManager;
import se.kth.iv1350.sem3.model.RepairOrder;

/**
 * Handles requests from the view and coordinates calls to the model and integration layers.
 */
public class Controller {
    private OrderManager manager;
    private CustomerRegistry customerRegistry;
    private RepairOrderRegistry repairOrderRegistry;
    private Printer printer;
    
    /**
     * Creates a new controller.
     *
     * @param manager Handles repair order business logic.
     * @param customerRegistry Stores and retrieves customers.
     * @param repairOrderRegistry Stores and retrieves repair orders.
     * @param printer Prints receipts through the external printer system.
     */
    public Controller(OrderManager manager, CustomerRegistry customerRegistry, RepairOrderRegistry repairOrderRegistry, Printer printer) {
        this.manager = manager;
        this.customerRegistry = customerRegistry;
        this.repairOrderRegistry = repairOrderRegistry;
        this.printer = printer;
    }

    /**
     * Registers a new customer.
     *
     * @param newCustomer The customer to register.
     */
    public void addCustomer(CustomerDTO newCustomer) {
        customerRegistry.addCustomer(newCustomer);
    }

    /**
     * Searches for a customer by phone number.
     *
     * @param phoneNumber The customer's phone number.
     * 
     * @return The matching customer, or {@code null} if no customer is found.
     */
    public CustomerDTO findCustomer(String phoneNumber) {
        return customerRegistry.findCustomer(phoneNumber);
    }

    /**
     * This method creates a repair order.
     * 
     * @param customer The customer object that is going to have a repair order.
     * @param date The date that the repair order is created.
     * @param problemDesc The problem description of the bike.
     * 
     * @return Returns the created repair order.
     */
    public RepairOrder createRepairOrder(CustomerDTO customer, String date, String problemDesc) {
        return manager.createRepairOrder(customer, date, problemDesc);
    }

    /**
     * This method finds a repair order.
     * 
     * @param customer The customer object.
     * 
     * @return Returns the repair order connected to the customer object.
     */
    public RepairOrder findRepairOrder(CustomerDTO customer) {
        return repairOrderRegistry.findRepairOrder(customer);
    }

    /**
     * Adds a diagnostic report to the repair order.
     * 
     * @param repairOrder The repair order object.
     * @param diagReport The diagnostic report.
     * 
     * @return Returns the updated repair order
     */
    public RepairOrder addDiagnosticReport(RepairOrder repairOrder, String diagReport) {
        return manager.addDiagnosticReport(repairOrder, diagReport);
    }

    /**
     * Creates a repair task object for a repair order.
     * 
     * @param repairOrder Is the repair order that is going to have the repair task.
     * @param name The name for the repair task.
     * @param taskDesc The task description for the repair task.
     * @param cost The cost of the repair task.
     * 
     * @return Returns the updated repair order.
     */
    public RepairOrder createRepairTask(RepairOrder repairOrder, String name, String taskDesc, double cost) {
        return manager.createRepairTask(repairOrder, name, taskDesc, cost);
    }

    /**
     * Accepts a repair order.
     * 
     * @param repairOrder The repair order to be accepted.
     * 
     * @return Returns the updated repair order.
     */
    public RepairOrder acceptRepairOrder(RepairOrder repairOrder) {
        return manager.acceptRepairOrder(repairOrder);
    }
    /**
     * Rejects a repair order.
     * 
     * @param repairOrder The repair order to be rejected.
     * 
     * @return Returns the updated repair order.
     */
    public RepairOrder rejectRepairOrder(RepairOrder repairOrder) {
        return manager.rejectRepairOrder(repairOrder);
    }

    /**
     * Prints a receipt for the specified repair order.
     *
     * @param repairOrder The repair order to print a receipt for.
     */
    public void printReceipt(RepairOrder repairOrder) {
        printer.printReceipt(repairOrder);
    }
}
