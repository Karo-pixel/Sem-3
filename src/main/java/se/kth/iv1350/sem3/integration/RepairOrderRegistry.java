package se.kth.iv1350.sem3.integration;
import java.util.ArrayList;
import se.kth.iv1350.sem3.model.Customer;
import se.kth.iv1350.sem3.model.RepairOrder;
import se.kth.iv1350.sem3.model.RepairTask;

/**
 * A class for the programs repair order registry.
 */
public class RepairOrderRegistry {
    private ArrayList<RepairOrder> listOfRepairOrders;

    /**
     * The classes cunstroctor.
     */
    public RepairOrderRegistry() {
        this.listOfRepairOrders = new ArrayList<>();
    }

    /**
     * Adds a new repair order to the database.
     * 
     * @param repairOrder Is the new repair order to be added.
     */
    public void addRepairOrder(RepairOrder repairOrder) {
        this.listOfRepairOrders.add(repairOrder);
    }

    /**
     * Finds a repair order from the database.
     * 
     * @param customer Is the customer that is connected to the repair order.
     * @return Returns the repair order that is found.
     */
    public RepairOrder findRepairOrder(Customer customer) {
        for (RepairOrder currentRepairOrder : listOfRepairOrders) {
            if (currentRepairOrder.getCustomer().getPhoneNumber().equals(customer.getPhoneNumber())) {
                return currentRepairOrder;
            }
        }
        return null;
    }

    /**
     * Adds a repair task to a repair order.
     * 
     * @param repairOrder Is the repair order that is going to have the repair task.
     * @param repairTask Is the repair task.
     */
    public void addRepairTask(RepairOrder repairOrder, RepairTask repairTask) {
        repairOrder.addRepairTask(repairTask);
    }

    /**
     * Gets repair tasks connected to a repair order.
     * 
     * @param repairOrder The repair order which its repair tasks are to be returned.
     */
    public String getRepairTasks(RepairOrder repairOrder) {
        return repairOrder.getRepairTasks();
    }



}
