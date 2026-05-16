package se.kth.iv1350.sem3.startup;

import se.kth.iv1350.sem3.integration.Printer;
import se.kth.iv1350.sem3.control.Controller;
import se.kth.iv1350.sem3.integration.CustomerRegistry;
import se.kth.iv1350.sem3.integration.RepairOrderRegistry;
import se.kth.iv1350.sem3.model.OrderManager;
import se.kth.iv1350.sem3.view.View;

/**
 * The main class of the program.
 */
public class Main {

    /**
     * Starts the application.
     * 
     * @param args Command line arguments. This program does not use them.
     */
    public static void main(String[] args) {
        CustomerRegistry customerRegistry = new CustomerRegistry();
        RepairOrderRegistry repairOrderRegistry = new RepairOrderRegistry();
        Printer printer = new Printer();
        OrderManager manager = new OrderManager(repairOrderRegistry);

        Controller contr = new Controller(manager, customerRegistry, repairOrderRegistry, printer);

        View view = new View(contr);
        view.start();
    }
}
