package se.kth.iv1350.sem3.model;
import java.util.ArrayList;

/**
 * A class for RepairOrder data type.
 */
public class RepairOrder {
    private Customer customer;
    private String date;
    private String problemDesc;
    private String diagReport;
    private boolean state;
    private ArrayList<RepairTask> listOfTasks;

    /**
     * The classes constructor.
     * 
     * @param customer The Customer data type.
     * @param date The date of the RepairOrder data types creation.
     * @param problemDesc The problem description for the repair order.
     */
    public RepairOrder(Customer customer, String date, String problemDesc) {
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
    public Customer getCustomer() {
        return this.customer;
    }

    /**
     * A method that adds a repair task to the repair order.
     * 
     * @param newRepairTask The repair task to be added.
     */
    public void addRepairTask(RepairTask newRepairTask) {
        this.listOfTasks.add(newRepairTask);
    }

    /**
     * A method that adds a diagnostic report to the repair order.
     * 
     * @param diagReport The diagnostic report.
     */
    public void addDiagnosticReport(String diagReport) {
        this.diagReport = diagReport;
    }

    /**
     * A method that calculates the total cost of all repair tasks.
     * 
     * @return Returns the total cost of all repair tasks.
     */
    public double getTotalCost() {
        double totalCost = 0;
        for (RepairTask currentRepairTask : listOfTasks) {
            totalCost = currentRepairTask.getCost() + totalCost;
        }
        return totalCost;
    }

    /**
     * A method that returns all the repair tasks.
     * 
     * @return Returns all repair tasks.
     */
    public String getRepairTasks() {
        String repairTasks = "";

        for (RepairTask currentRepairTask : listOfTasks) {
            repairTasks += currentRepairTask.toString() + "\n";
        }

        return repairTasks;
    }

    /**
     * A method that sets the state of the repair order.
     * 
     * @param newState The state of the repair order.
     */
    public void setState(boolean newState) {
        state = newState;
    }

    /**
     * A method that prints out the details of the repair order.
     */
    @Override
    public String toString() {
        return "-------------Repair Order--------------" + "\n" +
               "Customers name: " + this.customer.getName() + "\n" +
               "Date: " + this.date + "\n" +
               "Problem description: " + this.problemDesc + "\n" +
               "Diagnostic report: " + this.diagReport + "\n" +
               "The state of the order: " + this.state + "\n" +
               "Total cost of the repair order: " + getTotalCost() + " dollars." + "\n";
    }
    
    

}
