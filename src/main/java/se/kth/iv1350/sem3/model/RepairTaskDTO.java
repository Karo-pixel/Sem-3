package se.kth.iv1350.sem3.model;

/**
 * Contains information about a repair task.
 */
public class RepairTaskDTO {
    private String name;
    private String desc;
    private double cost;

    /**
     * The classes constructor.
     * 
     * @param name The RepairTasks name.
     * @param desc The RepairTasks description.
     * @param cost The RepairTasks cost.
     */
    public RepairTaskDTO(String name, String desc, double cost) {
        this.name = name;
        this.desc = desc;
        this.cost = cost;
    }

    /**
     * A getter method that returns the repair tasks name.
     * 
     * @return Returns the repair tasks name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * A getter method that returns the repair tasks description.
     * 
     * @return Returns the repair tasks description.
     */
    public String getDesc() {
        return this.desc;
    }

    /**
     * A getter method that returns the repair tasks cost.
     * 
     * @return Returns the repair tasks cost.
     */
    public double getCost() {
        return this.cost;
    }
}
