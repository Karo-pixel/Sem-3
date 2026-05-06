package se.kth.iv1350.sem3.startup;

import se.kth.iv1350.sem3.integration.Printer;
import se.kth.iv1350.sem3.control.Controller;
import se.kth.iv1350.sem3.integration.CustomerRegistry;
import se.kth.iv1350.sem3.integration.RepairOrderRegistry;
import se.kth.iv1350.sem3.model.OrderManager;
import se.kth.iv1350.sem3.view.View;

/**
 * The class main for the program.
 */
public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        CustomerRegistry customerRegistry = new CustomerRegistry();
        RepairOrderRegistry repairOrderRegistry = new RepairOrderRegistry();
        OrderManager manager = new OrderManager(customerRegistry, repairOrderRegistry);

        Controller contr = new Controller(manager, customerRegistry, repairOrderRegistry, printer);

        View view = new View(contr);
        view.start();
    }
}
