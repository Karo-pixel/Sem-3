package se.kth.iv1350.sem3.model;
import java.util.ArrayList;

/**
 * Represents a repair order for a customer's bike.
 */
public class RepairOrder {
    private CustomerDTO customer;
    private String date;
    private String problemDesc;
    private String diagReport;
    private boolean state;
    private ArrayList<RepairTaskDTO> listOfTasks;

    /**
     * The classes first constructor.
     * 
     * @param customer The Customer data type.
     * @param date The date of the RepairOrder data types creation.
     * @param problemDesc The problem description for the repair order.
     */
    public RepairOrder(CustomerDTO customer, String date, String problemDesc) {
        this.customer = customer;
        this.date = date;
        this.problemDesc = problemDesc;
        this.listOfTasks = new ArrayList<>();
    }

    /**
     * Creates a copy of an existing repair order.
     *
     * @param oldRepairOrder The repair order to copy.
     */
    public RepairOrder(RepairOrder oldRepairOrder) {
        this.customer = oldRepairOrder.getCustomer();
        this.date = oldRepairOrder.getDate();
        this.problemDesc = oldRepairOrder.getProblemDesc();
        this.diagReport = oldRepairOrder.getDiagReport();
        this.state = oldRepairOrder.getState();
        this.listOfTasks = new ArrayList<>(oldRepairOrder.getListOfTasks());
    }

    /**
     * A getter method that returns the customer.
     * 
     * @return Returns the customer.
     */
    public CustomerDTO getCustomer() {
        return this.customer;
    }

    /**
     * A getter method that returns the date.
     * 
     * @return Returns the date.
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Gets the problem description.
     *
     * @return The problem description.
     */
    public String getProblemDesc() {
        return this.problemDesc;
    }

    /**
     * Sets the diagnostic report for this repair order.
     *
     * @param diagReport The diagnostic report.
     */
    public void setDiagnosticReport(String diagReport) {
        this.diagReport = diagReport;
    }

    /**
     * A getter method that returns the diagnostic report.
     * 
     * @return Returns the diagnostic report.
     */
    public String getDiagReport() {
        return this.diagReport;
    }

    /**
     * Sets whether this repair order has been accepted.
     *
     * @param newState {@code true} if the order is accepted, {@code false} if it is rejected.
     */
    public void setState(boolean newState) {
        this.state = newState;
    }

    /**
     * Checks whether this repair order has been accepted.
     *
     * @return {@code true} if the order is accepted, {@code false} if it is rejected.
     */
    public boolean getState() {
        return this.state;
    }

    /**
     * A method that adds a repair task to a repair order.
     * 
     * @param repairTask The repair task to be added.
     */
    public void addRepairTask(RepairTaskDTO repairTask) {
        listOfTasks.add(repairTask);
    }

    /**
     * Gets a copy of the repair tasks included in this repair order.
     *
     * @return A copy of the list of repair tasks.
     */
    public ArrayList<RepairTaskDTO> getListOfTasks() {
        return new ArrayList<>(this.listOfTasks);
    }

    private double calculateTotalCost() {
        double totCost = 0;
        for (RepairTaskDTO currentRepairTask : listOfTasks) {
            totCost += currentRepairTask.getCost();
        }
        return totCost;
    }

    /**
     * Gets the total cost of all repair tasks in this order.
     *
     * @return The total cost of the repair order.
     */
    public double getTotalCost() {
        return calculateTotalCost();
    }
}
