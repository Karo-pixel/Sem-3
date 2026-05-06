package se.kth.iv1350.sem3.integration;
import se.kth.iv1350.sem3.model.Receipt;
import se.kth.iv1350.sem3.model.RepairOrder;


/**
 * A class for a printer.
 */
public class Printer {


    public Printer() {
    }

    /**
     * A method for printing a receipt.
     */
    public String printReceipt(RepairOrder repairOrder) {
        Receipt newReceipt = new Receipt(repairOrder);
        return newReceipt.toString();
    }
}
