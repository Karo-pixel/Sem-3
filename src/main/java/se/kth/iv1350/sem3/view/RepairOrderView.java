package se.kth.iv1350.sem3.view;

import se.kth.iv1350.sem3.model.RepairOrder;
import se.kth.iv1350.sem3.model.RepairOrderObserver;
import se.kth.iv1350.sem3.model.RepairTaskDTO;

/**
 * Shows updated repair orders in the user interface.
 */
public class RepairOrderView implements RepairOrderObserver {
    /**
     * Prints the updated repair order.
     *
     * @param repairOrder The updated repair order.
     */
    @Override
    public void repairOrderUpdated(RepairOrder repairOrder) {
        System.out.println("(For technician and receptionist) Repair order was updated:");
        System.out.println(getRepairOrder(repairOrder));
        System.out.println(getRepairTaskDTO(repairOrder));
    }

    private String getRepairOrder(RepairOrder repairOrder) {
        return "============Repair Order============" + "\n" +
               "Customers name: " + repairOrder.getCustomer().getName() + "\n" +
               "Date: " + repairOrder.getDate() + "\n" +
               "Problem description: " + repairOrder.getProblemDesc() + "\n" +
               "Diagnostic report: " + repairOrder.getDiagReport() + "\n" +
               "The state of the order: " + repairOrder.getState() + "\n" +
               "Total cost of the repair order: " + repairOrder.getTotalCost() + " dollars." + "\n" +
               "=====================================";
    } 

    private String getRepairTaskDTO(RepairOrder repairOrder) {
        String tasks = "";
        for (RepairTaskDTO currentRepairTaskDTO : repairOrder.getListOfTasks()) {
            tasks += "Repair Task name: " + currentRepairTaskDTO.getName() + "\n" +
                     "Repair Task description: " + currentRepairTaskDTO.getDesc() + "\n" +
                     "Repair Task cost: " + currentRepairTaskDTO.getCost() + " dollars" + "\n" +
                     "=======================================" + "\n";
        }
        return tasks;
    }
}