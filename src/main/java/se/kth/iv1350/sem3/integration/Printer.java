package se.kth.iv1350.sem3.integration;
import se.kth.iv1350.sem3.model.RepairOrder;


/**
 * Simulates an external printer system that prints receipts.
 */
public class Printer {


    /**
     * Creates a printer representing the external printer system.
     */
    public Printer() {
    }

    /**
     * Prints a receipt for the specified repair order.
     *
     * @param repairOrder The repair order to print a receipt for.
     */
    public void printReceipt(RepairOrder repairOrder) {
        System.out.println("----------------Receipt----------------");
        System.out.println("Receipt for: " + repairOrder.getCustomer().getName());
        System.out.println("At the date: " + repairOrder.getDate());
        System.out.println("Technicians report: " + repairOrder.getDiagReport());
        System.out.println("Number of tasks: " + repairOrder.getListOfTasks().size());
        System.out.println("Total cost of tasks: " + repairOrder.getTotalCost() + " dollars.");
        System.out.println("State of the repair order: " + repairOrder.getState() + "\n");
    }
}
