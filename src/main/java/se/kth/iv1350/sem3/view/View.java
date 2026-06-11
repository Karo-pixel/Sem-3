package se.kth.iv1350.sem3.view;
import se.kth.iv1350.sem3.control.Controller;
import se.kth.iv1350.sem3.model.BikeDTO;
import se.kth.iv1350.sem3.model.CustomerDTO;
import se.kth.iv1350.sem3.model.RepairOrder;
import se.kth.iv1350.sem3.model.RepairTaskDTO;
import se.kth.iv1350.sem3.integration.CustomerNotFoundException;
import se.kth.iv1350.sem3.integration.DatabaseFailureException;
import se.kth.iv1350.sem3.log.FileLogger;
import se.kth.iv1350.sem3.log.RepairOrderLogger;

/**
 * Represents the user interface and runs a sample repair order scenario.
 */
public class View {
    private Controller contr;
    private FileLogger logger = new FileLogger();

    /**
     * Creates a view that uses the specified controller.
     *
     * @param contr The controller used to perform system operations.
     */
    public View(Controller contr) {
        this.contr = contr;
        contr.addRepairOrderObserver(new RepairOrderView());
        contr.addRepairOrderObserver(new RepairOrderLogger());
    }

    /**
     * Starts the user interface by running a sample repair order scenario.
     */
    public void start() {
        BikeDTO bike = new BikeDTO("Lexus", "Tiger", "55");
        CustomerDTO newCustomer = new CustomerDTO("Karo", "karosh@kth.se", "0704345829", bike);

        contr.addCustomer(newCustomer);

        System.out.println("Customer is found through their phone number, details are printed: \n");

        try {
            CustomerDTO found = contr.findCustomer("0704345829");
            System.out.println(getCustomerDTO(found)); 
        } catch (CustomerNotFoundException e) {
            System.out.println("Customer could not be found \n" + e);
        } catch (DatabaseFailureException e) {
            System.out.println("The system could not find the customer at the moment. Please try again later.");
            logger.logException(e);
        }

        RepairOrder repOrder = contr.createRepairOrder(newCustomer, "06/23", "My bike does not move.");
        repOrder = contr.addDiagnosticReport(repOrder, "The wheels and brakes need to be changed");

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
                     "Repair Task cost: " + currentRepairTaskDTO.getCost() + " dollars" + "\n" + "\n";
        }
        return tasks;
    }


}
