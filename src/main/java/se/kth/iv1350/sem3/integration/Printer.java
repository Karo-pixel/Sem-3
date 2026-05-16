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
        System.out.println(repairOrder);
    }
}
