package se.kth.iv1350.sem3.view;
import se.kth.iv1350.sem3.control.Controller;
import se.kth.iv1350.sem3.model.Bike;
import se.kth.iv1350.sem3.model.Customer;
import se.kth.iv1350.sem3.model.RepairOrder;


public class View {
    private Controller contr;

    public View(Controller contr) {
        this.contr = contr;
    }

    public void start() {
        Bike bike = new Bike("Lexus", "Tiger", "55");
        Customer newCustomer = new Customer("Karo", "karosh@kth.se", "0704345829", bike);

        contr.addCustomer(newCustomer);

        Customer found = contr.findCustomer("0704345829");

        System.out.println("Customer is found and details are printed: ");

        System.out.println(found);
        System.out.println(found.getBike());

        RepairOrder newRepairOrder = contr.createRepairOrder(found, "2026-04-10", "The brakes don't work.");

        System.out.println("Repair order is created and printed: ");
        System.out.println(newRepairOrder);

        contr.addDiagnosticReport(newRepairOrder, "The brakes and wheels need to be changed.");

        System.out.println("The repair order after diagnostic report is added: ");
        System.out.println(newRepairOrder);

        contr.createRepairTask(newRepairOrder, "Wheels", "Wheels are too old.", 70);
        contr.createRepairTask(newRepairOrder, "Brakes", "Brakes are damaged", 20);

        System.out.println("The repair order after repair tasks are added: ");
        System.out.println(contr.getRepairTasks(newRepairOrder));
        System.out.println(newRepairOrder);

        System.out.println("The repair order after it is accepted: ");
        contr.acceptRepairOrder(newRepairOrder);
        System.out.println(newRepairOrder);

        System.out.println("The receipt: ");
        System.out.println(contr.getReceipt(newRepairOrder));
        

    }


}
