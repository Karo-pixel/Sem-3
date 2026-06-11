package se.kth.iv1350.sem3.model;

/**
 * Observer interface for classes that want to be notified when a repair order is updated.
 */
public interface RepairOrderObserver {
    /**
     * Called when a repair order has been updated.
     *
     * @param repairOrder The updated repair order.
     */
    void repairOrderUpdated(RepairOrder repairOrder);
}