public class Customer {
    private int NumberofSequence;
    private String names;
    private String IDparcel;

    public Customer(int NumberofSequence, String names, String IDparcel) {
        this.NumberofSequence = NumberofSequence;
        this.names = names;
        this.IDparcel = IDparcel;
    }

    public int getSequenceNumber() {
        return NumberofSequence;
    }

    public String getName() {
        return names;
    }

    public String getParcelID() {
        return IDparcel;
    }
}
