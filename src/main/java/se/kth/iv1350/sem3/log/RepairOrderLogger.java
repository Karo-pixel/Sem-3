package se.kth.iv1350.sem3.log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import se.kth.iv1350.sem3.model.RepairOrder;
import se.kth.iv1350.sem3.model.RepairOrderObserver;

/**
 * Logs updated repair orders to a file.
 */
public class RepairOrderLogger implements RepairOrderObserver {
    private PrintWriter logFile;

    /**
     * Creates a new logger that writes repair order updates to a file.
     */
    public RepairOrderLogger() {
        try {
            logFile = new PrintWriter(new FileWriter("repair-order-log.txt"), true);
        } catch (IOException exc) {
            System.out.println("Could not create repair order log file.");
        }
    }

    /**
     * Logs the updated repair order.
     *
     * @param repairOrder The updated repair order.
     */
    @Override
    public void repairOrderUpdated(RepairOrder repairOrder) {
        if (logFile != null) {
            logFile.println("Repair order was updated:");
            logFile.println(getRepairOrder(repairOrder));
            logFile.println();
        }
    }

    private String getRepairOrder(RepairOrder repairOrder) {
        return "-------------Repair Order--------------" + "\n" +
               "Customers name: " + repairOrder.getCustomer().getName() + "\n" +
               "Date: " + repairOrder.getDate() + "\n" +
               "Problem description: " + repairOrder.getProblemDesc() + "\n" +
               "Diagnostic report: " + repairOrder.getDiagReport() + "\n" +
               "The state of the order: " + repairOrder.getState() + "\n" +
               "Total cost of the repair order: " + repairOrder.getTotalCost() + " dollars." + "\n";
    } 
}