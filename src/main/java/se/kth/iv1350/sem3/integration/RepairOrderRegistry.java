package se.kth.iv1350.sem3.integration;
import java.util.ArrayList;
import se.kth.iv1350.sem3.model.CustomerDTO;
import se.kth.iv1350.sem3.model.RepairOrder;

/**
 * Simulates a database that stores repair orders.
 */
public class RepairOrderRegistry {
    private ArrayList<RepairOrder> listOfRepairOrders;

    /**
     * Creates an empty repair order registry.
     */
    public RepairOrderRegistry() {
        this.listOfRepairOrders = new ArrayList<>();
    }

    /**
     * Adds a copy of a repair order to the simulated database.
     *
     * @param repairOrder The repair order to copy and store.
     */
    public void addRepairOrder(RepairOrder repairOrder) {
        this.listOfRepairOrders.add(new RepairOrder(repairOrder));
    }

    /**
     * Searches for a repair order belonging to the specified customer.
     *
     * @param customer The customer whose repair order is searched for.
     * 
     * @return A copy of the matching repair order, or {@code null} if no repair order is found.
     */
    public RepairOrder findRepairOrder(CustomerDTO customer) {
        for (RepairOrder currentRepairOrder : listOfRepairOrders) {
            if (currentRepairOrder.getCustomer().getPhoneNumber().equals(customer.getPhoneNumber())) {
                return new RepairOrder(currentRepairOrder);
            }
        }
        return null;
    }

    /**
     * Updates the simulated database by replacing an old repair order with an updated one.
     *
     * @param oldRepairOrder The repair order to replace.
     * @param newRepairOrder The updated repair order to store.
     * 
     * @return A copy of the updated repair order, or {@code null} if the old repair order was not found.
     */
    public RepairOrder updateRepairOrder(RepairOrder oldRepairOrder, RepairOrder newRepairOrder) {
        for (int i = 0; i < listOfRepairOrders.size(); i++) {
            if (listOfRepairOrders.get(i).getCustomer().getPhoneNumber().equals(oldRepairOrder.getCustomer().getPhoneNumber())) {
                listOfRepairOrders.set(i, newRepairOrder);
                return new RepairOrder(newRepairOrder);
            }
        }
        return null;
    }




}
