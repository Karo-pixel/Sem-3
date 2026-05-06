package se.kth.iv1350.sem3.model;

/**
 * A class for Receipt data type.
 */
public class Receipt {
    private RepairOrder repairOrder;

    /**
     * The classes constructor.
     * 
     * @param repairOrder The repair order that is going to get a receipt.
     */
    public Receipt(RepairOrder repairOrder) {
        this.repairOrder = repairOrder;
    }

    /**
     * A method that returns the receipt.
     */
    @Override
    public String toString() {
        return "-----------------Receipt-----------------" + "\n" + 
        repairOrder + "\n" +
        "-----------Repair Tasks---------" + "\n" +
        repairOrder.getRepairTasks();
    }

}
