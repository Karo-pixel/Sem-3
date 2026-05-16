package se.kth.iv1350.sem3.model;
import java.util.ArrayList;

/**
 * A class for RepairOrder data type.
 */
public class RepairOrder {
    private CustomerDTO customer;
    private String date;
    private String problemDesc;
    private String diagReport;
    private boolean state;
    private double totalCost;
    private ArrayList<RepairTaskDTO> listOfTasks;

    /**
     * The classes constructor.
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
     * A getter method that returns the customer.
     * 
     * @return Returns the customer.
     */
    public CustomerDTO getCustomer() {
        return this.customer;
    }

    public String getDate() {
        return this.date;
    }

    public String getProblemDesc() {
        return this.problemDesc;
    }

    /**
     * A method that adds a diagnostic report to the repair order.
     * 
     * @param diagReport The diagnostic report.
     */
    public void setDiagnosticReport(String diagReport) {
        this.diagReport = diagReport;
    }

    public String getDiagReport() {
        return this.diagReport;
    }

    /**
     * A method that sets the state of the repair order.
     * 
     * @param newState The state of the repair order.
     */
    public void setState(boolean newState) {
        this.state = newState;
    }

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

    public ArrayList<RepairTaskDTO> getListOfTasks() {
        return this.listOfTasks;
    }

    /**
     * A method that calculates the total cost of all repair tasks and returns it.
     * 
     * @return The total cost of all repair tasks.
     */
    private double calculateTotalCost() {
        double totCost = 0;
        for (RepairTaskDTO currentRepairTask : listOfTasks) {
            totCost += currentRepairTask.getCost();
        }
        return totCost;
    }

    /**
     * A method for returning the total cost of the repair order.
     * 
     * @return Returns the total cost.
     */
    public double getTotalCost() {
        this.totalCost = calculateTotalCost();
        return this.totalCost;
    }
}
