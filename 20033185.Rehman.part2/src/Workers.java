public class Workers {
    private MapParcel mapParcel;
    private CustomersQueue queue;
    private Logs logs;

    public Workers(MapParcel mapParcel, CustomersQueue queue) {
        this.mapParcel = mapParcel;
        this.queue = queue;
        this.logs = Logs.getInstance(); // Using the Singleton Log instance
    }

    public MapParcel getParcelMap() {
        return mapParcel;
    }

    public CustomersQueue getQueue() {
        return queue;
    }

    public void processCustomer() {
        if (!queue.isEmpty()) {
            Customer customer = queue.processNextCustomer();
            Parcel parcel = mapParcel.getParcel(customer.getParcelID());
            if (parcel != null && !parcel.isCollected()) {
                double fee = parcel.calculateFee();
                parcel.markAsCollected();

                // Log the processed customer
                String logEntry = "Processed: " + customer.getName() + ", Parcel ID: " + parcel.getParcelID() + ", Fee: " + fee;
                logs.addEntry(logEntry);
                System.out.println(logEntry);
            } else {
                // Log a missing or already collected parcel
                String logEntry = "Parcel not found or already collected for customer: " + customer.getName();
                logs.addEntry(logEntry);
                System.out.println(logEntry);
            }
        }
    }

    public void addCustomerToQueue(Customer customer) {
        queue.addCustomer(customer);
        logs.addEntry("New customer added: " + customer.getName() + ", Parcel ID: " + customer.getParcelID());
        System.out.println("New customer added: " + customer.getName() + ", Parcel ID: " + customer.getParcelID());
    }

    public void removeCustomer() {
        if (!queue.isEmpty()) {
            Customer removedCustomer = queue.processNextCustomer();
            logs.addEntry("Customer removed: " + removedCustomer.getName() + ", Parcel ID: " + removedCustomer.getParcelID());
            System.out.println("Customer removed: " + removedCustomer.getName() + ", Parcel ID: " + removedCustomer.getParcelID());
        } else {
            System.out.println("No customers to remove.");
        }
    }
}
