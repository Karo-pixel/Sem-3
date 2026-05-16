package se.kth.iv1350.sem3.integration;
import java.util.ArrayList;
import se.kth.iv1350.sem3.model.CustomerDTO;
import se.kth.iv1350.sem3.model.RepairOrder;

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
    public RepairOrder findRepairOrder(CustomerDTO customer) {
        for (RepairOrder currentRepairOrder : listOfRepairOrders) {
            if (currentRepairOrder.getCustomer().getPhoneNumber().equals(customer.getPhoneNumber())) {
                return currentRepairOrder;
            }
        }
        return null;
    }




}
