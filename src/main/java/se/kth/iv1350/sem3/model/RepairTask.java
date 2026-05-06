package se.kth.iv1350.sem3.model;

/**
 * A class for RepairTask data type.
 */
public class RepairTask {
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
    public RepairTask(String name, String desc, double cost) {
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

    /**
     * A method that prints out the repair tasks information.
     */
    @Override
    public String toString() {
        return "Repair Task name: " + this.name + "\n" +
               "Repair Task description: " + this.desc + "\n" +
               "Repair Task cost: " + this.cost + " dollars." + "\n";
    }

}
