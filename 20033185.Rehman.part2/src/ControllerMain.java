import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerMain {
    private frame view;
    private Workers worker;

    public ControllerMain(frame view, Workers worker) {
        this.view = view;
        this.worker = worker;

        view.populateParcelTable(worker.getParcelMap());
        view.populateCustomerQueueTable(worker.getQueue());

        view.getProcessNextButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                worker.processCustomer();
                updateView();
            }
        });

        view.getAddCustomerButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adding a new customer to the queue
                Customer newCustomer = new Customer(31, "New Customer", "X999");
                worker.addCustomerToQueue(newCustomer);
                updateView();
            }
        });

        view.getRemoveCustomerButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                worker.removeCustomer();
                updateView();
            }
        });
    }

    private void updateView() {
        view.populateParcelTable(worker.getParcelMap());
        view.populateCustomerQueueTable(worker.getQueue());


        if (!worker.getQueue().isEmpty()) {
            Customer nextCustomer = worker.getQueue().peekNextCustomer();
            if (nextCustomer != null) {
                view.getCurrentParcelLabel().setText("Current Parcels: " + nextCustomer.getParcelID());
            }
        } else {
            view.getCurrentParcelLabel().setText("Out of parcels to process. ");
        }
    }
}

