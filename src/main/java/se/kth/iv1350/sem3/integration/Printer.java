package se.kth.iv1350.sem3.integration;
import se.kth.iv1350.sem3.model.RepairOrder;


/**
 * A class for a printer.
 */
public class Printer {


    /**
     * Creates a new printer.
     */
    public Printer() {
    }

    /**
     * A method that creates and returns a receipt.
     * 
     * @param repairOrder The repair order that the receipt is based on.
     * 
     * @return Returns the created receipt.
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
