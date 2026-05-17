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
     * 
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
     * 
     * @return Returns the updated repair order.
     */
    public RepairOrder addDiagnosticReport(RepairOrder repairOrder, String diagReport) {
        RepairOrder newRepairOrder = new RepairOrder(repairOrder);
        newRepairOrder.setDiagnosticReport(diagReport);
        return repairOrderRegistry.updateRepairOrder(repairOrder, newRepairOrder);
    } 

    /**
     * Creates a repair task and adds it to the repair order.
     * 
     * @param repairOrder The repair order that is going to have the repair task.
     * @param name The names of the repair task.
     * @param taskDesc The description of the repair task.
     * @param cost The cost of the repair task.
     * 
     * @return Returns the updated repair order.
     */
    public RepairOrder createRepairTask(RepairOrder repairOrder, String name, String taskDesc, double cost) {
        RepairTaskDTO repairTask = new RepairTaskDTO(name, taskDesc, cost);
        RepairOrder newRepairOrder = new RepairOrder(repairOrder);
        newRepairOrder.addRepairTask(repairTask);
        return repairOrderRegistry.updateRepairOrder(repairOrder, newRepairOrder);
    }

    /**
     * Accepts the repair order.
     * 
     * @param repairOrder The repair order to be accepted.
     * 
     * @return Returns the updated repair order.
     */
    public RepairOrder acceptRepairOrder(RepairOrder repairOrder) {
        RepairOrder newRepairOrder = new RepairOrder(repairOrder);
        newRepairOrder.setState(true);
        return repairOrderRegistry.updateRepairOrder(repairOrder, newRepairOrder);
    }

    /**
     * Rejects the repair order.
     * 
     * @param repairOrder The repair order to be rejected.
     * 
     * @return Returns the updated repair order.
     */
    public RepairOrder rejectRepairOrder(RepairOrder repairOrder) {
        RepairOrder newRepairOrder = new RepairOrder(repairOrder);
        newRepairOrder.setState(false);
        return repairOrderRegistry.updateRepairOrder(repairOrder, newRepairOrder);
    }

}
