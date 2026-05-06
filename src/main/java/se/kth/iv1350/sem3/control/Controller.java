package se.kth.iv1350.sem3.control;
import se.kth.iv1350.sem3.integration.Printer;
import se.kth.iv1350.sem3.integration.CustomerRegistry;
import se.kth.iv1350.sem3.integration.RepairOrderRegistry;
import se.kth.iv1350.sem3.model.Customer;
import se.kth.iv1350.sem3.model.OrderManager;
import se.kth.iv1350.sem3.model.RepairOrder;
import se.kth.iv1350.sem3.model.Receipt;
/**
 * The programs Controller that manages calls from the view.
 */
public class Controller {
    private OrderManager manager;
    private CustomerRegistry customerRegistry;
    private RepairOrderRegistry repairOrderRegistry;
    private Printer printer;
    
    /**
     * Creates a controller.
     * 
     * @param manager This is the programs order manager.
     * @param customerRegistry This is the programs customer registry.
     * @param repairOrderRegistry This is the programs repair order registry.
     * @param printer This is the programs printer.
     */
    public Controller(OrderManager manager, CustomerRegistry customerRegistry, RepairOrderRegistry repairOrderRegistry, Printer printer) {
        this.manager = manager;
        this.customerRegistry = customerRegistry;
        this.repairOrderRegistry = repairOrderRegistry;
        this.printer = printer;
    }

    /**
     * This method adds a customer object to the database.
     * 
     * @param newCustomer is the customer object that gets added.
    */
    public void addCustomer(Customer newCustomer) {
        customerRegistry.addCustomer(newCustomer);
    }

    /**
     * This method finds a customer from the database.
     * 
     * @param phoneNumber is the customers phone number.
     * 
     * @return the method returns the found customer object.
    */
    public Customer findCustomer(String phoneNumber) {
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
    public RepairOrder createRepairOrder(Customer customer, String date, String problemDesc) {
        return manager.createRepairOrder(customer, date, problemDesc);
    }

    /**
     * This method finds a repair order.
     * 
     * @param customer The customer object.
     * 
     * @return Returns the repair order connected to the customer object.
     */
    public RepairOrder findRepairOrder(Customer customer) {
        return repairOrderRegistry.findRepairOrder(customer);
    }

    /**
     * Adds a diagnostic report to the repair order.
     * 
     * @param repairOrder The repair order object.
     * @param diagReport The diagnostic report.
     */
    public void addDiagnosticReport(RepairOrder repairOrder, String diagReport) {
        manager.addDiagnosticReport(repairOrder, diagReport);
    }

    /**
     * Creates a repair task object for a repair order.
     * 
     * @param repairOrder Is the repair order that is going to have the repair task.
     * @param name The name for the repair task.
     * @param taskDesc The task description for the repair task.
     * @param cost The cost of the repair task.
     */
    public void createRepairTask(RepairOrder repairOrder, String name, String taskDesc, double cost) {
        manager.createRepairTask(repairOrder, name, taskDesc, cost);
    }

    /**
     * Returns all repair tasks connected to a repair order.
     * 
     * @param repairOrder The repair orders repair tasks that are to be shown.
     */
    public String getRepairTasks(RepairOrder repairOrder) {
        return repairOrderRegistry.getRepairTasks(repairOrder);
    }

    /**
     * Accepts a repair order.
     * 
     * @param repairOrder The repair order to be accepted.
     */
    public void acceptRepairOrder(RepairOrder repairOrder) {
        manager.acceptRepairOrder(repairOrder);
    }
    /**
     * Rejects a repair order.
     * 
     * @param repairOrder The repair order to be rejected.
     */
    public void rejectRepairOrder(RepairOrder repairOrder) {
        manager.rejectRepairOrder(repairOrder);
    }

    /**
     * This method gets a receipt.
     * 
     * @param repairOrder The repair order that the receipt is based on.
     * 
     * @return Returns the receipt.
     */
    public Receipt getReceipt(RepairOrder repairOrder) {
        return printer.getReceipt(repairOrder);
    }
}
