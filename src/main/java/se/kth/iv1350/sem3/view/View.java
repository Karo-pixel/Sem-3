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
        CustomerDTO found = null;

        System.out.println("Customer is searched for by their phone number, details are printed if the customer is found: \n");

        try {
            found = contr.findCustomer("000");
            System.out.println(getCustomerDTO(found)); 
            System.out.println(getBikeDTO(bike));
        } catch (CustomerNotFoundException e) {
            System.out.println("Customer could not be found because: " + e.getMessage());
            return;
        } catch (DatabaseFailureException e) {
            System.out.println("The system could not find the customer at the moment. Please try again later.");
            logger.logException(e);
            return;
        }

        System.out.println("A repair order is created for the customer: \n");

        RepairOrder repOrder = contr.createRepairOrder(found, "06/23", "My bike does not move.");
        System.out.println(getRepairOrder(repOrder));

        System.out.println("A diagnostic report is added to the repair order:\n");

        repOrder = contr.addDiagnosticReport(repOrder, "The wheels and brakes need to be changed");
        System.out.println(getRepairOrder(repOrder));

        System.out.println("Two repair tasks are added to the repair order: \n");

        repOrder = contr.createRepairTask(repOrder, "Wheels", "Wheels are damaged, need replacing.", 100);
        repOrder = contr.createRepairTask(repOrder, "Brakes", "Bike needs new brakes.", 299);
        System.out.println(getRepairTaskDTO(repOrder));

        System.out.println("The repair order after it is accepted:\n");

        repOrder = contr.acceptRepairOrder(repOrder);
        System.out.println(getRepairOrder(repOrder));

        System.out.println("The receipt:\n");

        contr.printReceipt(repOrder);

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
