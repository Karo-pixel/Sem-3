package se.kth.iv1350.sem3.view;
import se.kth.iv1350.sem3.control.Controller;
import se.kth.iv1350.sem3.model.BikeDTO;
import se.kth.iv1350.sem3.model.CustomerDTO;
import se.kth.iv1350.sem3.model.RepairOrder;
import se.kth.iv1350.sem3.model.RepairTaskDTO;

/**
 * The programs view class.
 */
public class View {
    private Controller contr;

    /**
     * Creates a view.
     * 
     * @param contr This is the programs controller.
     */
    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * Starts the program by running a sample repair order scenario.
     */
    public void start() {
        BikeDTO bike = new BikeDTO("Lexus", "Tiger", "55");
        CustomerDTO newCustomer = new CustomerDTO("Karo", "karosh@kth.se", "0704345829", bike);

        contr.addCustomer(newCustomer);

        System.out.println("Customer is found through their phone number, details are printed: \n");

        CustomerDTO found = contr.findCustomer("0704345829");
        System.out.println(getCustomerDTO(found));
        System.out.println(getBikeDTO(found.getBike()));

        System.out.println("A repair order is created and printed: \n");

        RepairOrder rep = contr.createRepairOrder(found, "2026-04-10", "The brakes don't work.");
        System.out.println(getRepairOrder(rep));


        System.out.println("The repair order after a diagnostic report is added: \n");

        rep = contr.addDiagnosticReport(rep, "The brakes and wheels need to be changed.");
        System.out.println(getRepairOrder(rep));


        System.out.println("The repair order after repair tasks are added: \n");

        rep = contr.createRepairTask(rep, "Wheels", "Wheels are too old.", 70);
        rep = contr.createRepairTask(rep, "Brakes", "Brakes are damaged", 20);
        rep = contr.createRepairTask(rep, "Chassi", "The chassi is rusted", 110);
        System.out.println(getRepairTaskDTO(rep));
        System.out.println(getRepairOrder(rep));

        System.out.println("The repair order after it is accepted: \n");

        rep = contr.acceptRepairOrder(rep);
        System.out.println(getRepairOrder(rep));

        System.out.println("The receipt: \n");

        contr.getReceipt(rep);
        
    }

    private String getBikeDTO(BikeDTO bike) {
        return "Bike brand: " + bike.getBikeBrand() + "\n" +
               "Bike model: " + bike.getBikeModel() + "\n" + 
               "Bike Serial Number: " + bike.getBikeSerialNo() + "\n";
    }

    private String getCustomerDTO(CustomerDTO customer) {
        return "Customer name: " + customer.getName() + "\n" +
               "Email: " + customer.getEmail() + "\n" +
               "Phone number: " + customer.getPhoneNumber() + "\n";

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
    

    private String getRepairTaskDTO(RepairOrder repairOrder) {
        String tasks = "";
        for (RepairTaskDTO currentRepairTaskDTO : repairOrder.getListOfTasks()) {
            tasks += "Repair Task name: " + currentRepairTaskDTO.getName() + "\n" +
                     "Repair Task description: " + currentRepairTaskDTO.getDesc() + "\n" +
                     "Repair Task cost: " + currentRepairTaskDTO.getCost() + "\n" + "\n";
        }
        return tasks;
    }


}
