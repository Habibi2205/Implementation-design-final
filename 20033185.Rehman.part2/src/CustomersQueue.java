import java.util.LinkedList;
import java.util.List;

public class CustomersQueue {
    private LinkedList<Customer> queue;

    public CustomersQueue() {
        this.queue = new LinkedList<>();
    }


    public void addCustomer(Customer customer) {
        queue.addLast(customer);
    }


    public Customer processNextCustomer() {
        return queue.pollFirst();
    }



    public Customer peekNextCustomer() {
        return queue.peekFirst();
    }


    public boolean isEmpty() {
        return queue.isEmpty();
    }


    public void removeCustomer(String IDparcel) {
        queue.removeIf(customer -> customer.getParcelID().equals(IDparcel));
    }


    public List<Customer> getAllCustomers() {
        return new LinkedList<>(queue);
    }
}
