import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class frame extends JFrame {
    private JTable parcelTable;
    private JTable customerQueueTable;
    private JLabel currentParcelLabel;
    private JButton processNextButton;
    private JButton addCustomerButton;
    private JButton removeCustomerButton;

    public frame() {
        setTitle("Parcel Processing System Depot");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize tables with empty models
        parcelTable = new JTable(new DefaultTableModel(new Object[]{"ID Parcel", "Days", "Weight", "Dimensions", "Status"}, 0));
        customerQueueTable = new JTable(new DefaultTableModel(new Object[]{"Sequence No.", "Name of Customer", "ID Parcel"}, 0));

        currentParcelLabel = new JLabel("Current Parcel: None");
        processNextButton = new JButton("Processing the Next Customer");
        addCustomerButton = new JButton("Adding a New Customer");
        removeCustomerButton = new JButton("Removing a Customer");

        // Layout setup
        setLayout(new BorderLayout());
        add(new JScrollPane(parcelTable), BorderLayout.WEST);
        add(new JScrollPane(customerQueueTable), BorderLayout.CENTER);
        add(currentParcelLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(processNextButton);
        buttonPanel.add(addCustomerButton);
        buttonPanel.add(removeCustomerButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public JTable getParcelTable() {
        return parcelTable;
    }

    public JTable getCustomerQueueTable() {
        return customerQueueTable;
    }

    public JLabel getCurrentParcelLabel() {
        return currentParcelLabel;
    }

    public JButton getProcessNextButton() {
        return processNextButton;
    }

    public JButton getAddCustomerButton() {
        return addCustomerButton;
    }

    public JButton getRemoveCustomerButton() {
        return removeCustomerButton;
    }

    public void populateParcelTable(MapParcel mapParcel) {
        DefaultTableModel model = (DefaultTableModel) parcelTable.getModel();
        model.setRowCount(0); // Clear existing rows
        for (Parcel parcel : mapParcel.getAllParcels()) {
            model.addRow(new Object[]{
                    parcel.getParcelID(),
                    parcel.getDaysInDepot(),
                    parcel.getWeight(),
                    parcel.getDimensions(),
                    parcel.isCollected() ? "Collected" : "Waiting"
            });
        }
    }


    public void populateCustomerQueueTable(CustomersQueue queue) {
        DefaultTableModel model = (DefaultTableModel) customerQueueTable.getModel();
        model.setRowCount(0); // Clear existing rows
        for (Customer customer : queue.getAllCustomers()) {
            model.addRow(new Object[]{
                    customer.getSequenceNumber(),
                    customer.getName(),
                    customer.getParcelID()
            });
        }
    }
}
