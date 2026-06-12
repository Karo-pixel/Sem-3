package se.kth.iv1350.sem3.model;
import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.sem3.integration.RepairOrderRegistry;

/**
 * Handles business logic related to repair orders.
 */
public class OrderManager {
    private RepairOrderRegistry repairOrderRegistry;
    private List<RepairOrderObserver> repairOrderObservers = new ArrayList<>();

    /**
     * Creates an order manager that modifies and stores updated repair orders in the specified registry.
     *
     * @param repairOrderRegistry The registry used to store and update repair orders.
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
        notifyRepairOrderObservers(newRepairOrder);
        return newRepairOrder;

    }
    /**
     * Creates an updated copy of the specified repair order with the given diagnostic report,
     * stores it in the repair order registry, notifies the observers and returns the updated order.
     *
     * @param repairOrder The repair order to update.
     * @param diagReport The diagnostic report to add.
     * 
     * @return The updated repair order.
     */
    public RepairOrder addDiagnosticReport(RepairOrder repairOrder, String diagReport) {
        RepairOrder newRepairOrder = new RepairOrder(repairOrder);
        newRepairOrder.setDiagnosticReport(diagReport);
        return updateRepairOrderAndNotifyObservers(repairOrder, newRepairOrder);
    } 

    /**
     * Creates a repair task, adds it to an updated copy of the specified repair order,
     * stores the updated order in the registry, notifies the observers and returns it.
     *
     * @param repairOrder The repair order to add the task to.
     * @param name The name of the repair task.
     * @param taskDesc A description of the repair task.
     * @param cost The cost of the repair task.
     * 
     * @return The updated repair order.
     */
    public RepairOrder createRepairTask(RepairOrder repairOrder, String name, String taskDesc, double cost) {
        RepairTaskDTO repairTask = new RepairTaskDTO(name, taskDesc, cost);
        RepairOrder newRepairOrder = new RepairOrder(repairOrder);
        newRepairOrder.addRepairTask(repairTask);
        return updateRepairOrderAndNotifyObservers(repairOrder, newRepairOrder);
    }

    /**
     * Creates an updated copy of the specified repair order, marks it as accepted,
     * stores it in the registry, notifies the observers and returns it.
     *
     * @param repairOrder The repair order to accept.
     * 
     * @return The updated repair order.
     */
    public RepairOrder acceptRepairOrder(RepairOrder repairOrder) {
        RepairOrder newRepairOrder = new RepairOrder(repairOrder);
        newRepairOrder.setState(true);
        return updateRepairOrderAndNotifyObservers(repairOrder, newRepairOrder);
    }

    /**
     * Creates an updated copy of the specified repair order, marks it as rejected,
     * stores it in the registry, notifies the observers and returns it.
     *
     * @param repairOrder The repair order to reject.
     * @return The updated repair order.
     */
    public RepairOrder rejectRepairOrder(RepairOrder repairOrder) {
        RepairOrder newRepairOrder = new RepairOrder(repairOrder);
        newRepairOrder.setState(false);
        return updateRepairOrderAndNotifyObservers(repairOrder, newRepairOrder);
    }

    /**
     * Adds an observer that will be notified when a repair order is updated.
     *
     * @param observer The observer to add.
     */
    public void addRepairOrderObserver(RepairOrderObserver observer) {
        repairOrderObservers.add(observer);
    }

    /**
     * Notifies all observers that a repair order has been updated.
     *
     * @param repairOrder The updated repair order.
     */
    private void notifyRepairOrderObservers(RepairOrder repairOrder) {
        for (RepairOrderObserver observer : repairOrderObservers) {
            observer.repairOrderUpdated(repairOrder);
        }
    }

    /**
     * Updates a repair order in the registry and notifies all observers.
     *
     * @param repairOrder The old repair order to replace.
     * @param newRepairOrder The new updated repair order.
     * @return The updated repair order.
     */
    private RepairOrder updateRepairOrderAndNotifyObservers(RepairOrder repairOrder, RepairOrder newRepairOrder) {
        RepairOrder updatedRepairOrder = repairOrderRegistry.updateRepairOrder(repairOrder, newRepairOrder);
        notifyRepairOrderObservers(updatedRepairOrder);
        return updatedRepairOrder;
    }
}
