package se.kth.iv1350.sem3.model;
import se.kth.iv1350.sem3.integration.RepairOrderRegistry;

/**
 * Creates the class OrderManager for handling orders.
 */
public class OrderManager {
    private RepairOrderRegistry repairOrderRegistry;

    /**
     * The classes constructor.
     * 
     * @param customerRegistry The programs CustomerRegistry.
     * @param repairOrderRegistry The programs RepairOrderRegistry.
     */
    public OrderManager(RepairOrderRegistry repairOrderRegistry) {
        this.repairOrderRegistry = repairOrderRegistry;
    }

    /**
     * Creates a repair order.
     * 
     * @param customer The customer that is going to have the repair order.
     * @param date The date of creation of the repair order.
     * @param problemDesc The problem description of the bike.
     * @return Returns the newly created repair order.
     */
    public RepairOrder createRepairOrder(CustomerDTO customer, String date, String problemDesc) {
        RepairOrder newRepairOrder = new RepairOrder(customer, date, problemDesc);
        repairOrderRegistry.addRepairOrder(newRepairOrder);
        return newRepairOrder;

    }
    /**
     * Adds diagnostic report to a repair order
     * 
     * @param repairOrder The repair order that is getting a diagnostic report.
     * @param diagReport The diagnostic report.
     */
    public void addDiagnosticReport(RepairOrder repairOrder, String diagReport) {
        repairOrder.setDiagnosticReport(diagReport);
    } 

    /**
     * Creates a repair task and adds it to the repair order.
     * 
     * @param repairOrder The repair order that is going to have the repair task.
     * @param name The names of the repair task.
     * @param taskDesc The description of the repair task.
     * @param cost The cost of the repair task.
     */
    public void createRepairTask(RepairOrder repairOrder, String name, String taskDesc, double cost) {
        RepairTaskDTO repairTask = new RepairTaskDTO(name, taskDesc, cost);
        repairOrder.addRepairTask(repairTask);
    }

    /**
     * Accepts the repair order.
     * 
     * @param repairOrder The repair order to be accepted.
     */
    public void acceptRepairOrder(RepairOrder repairOrder) {
        repairOrder.setState(true);
    }

    /**
     * Rejects the repair order.
     * 
     * @param repairOrder The repair order to be rejected.
     */
    public void rejectRepairOrder(RepairOrder repairOrder) {
        repairOrder.setState(false);
    }

}
