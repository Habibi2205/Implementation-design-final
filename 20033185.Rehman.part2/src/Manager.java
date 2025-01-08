import java.io.*;

public class Manager {
    public static void main(String[] args) {
        MapParcel mapParcel = new MapParcel();
        CustomersQueue queue = new CustomersQueue();

        try (BufferedReader br = new BufferedReader(new FileReader("src/parcels.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 6) {
                    Parcel parcel = new Parcel(parts[0], Integer.parseInt(parts[1]), Double.parseDouble(parts[2]), parts[3] + "x" + parts[4] + "x" + parts[5]);
                    mapParcel.addParcel(parcel);
                } else {
                    System.out.println("Line Format Invalid: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src/customers.txt"))) {
            String line;
            int sequenceNumber = 1;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    String name = parts[0] + " " + parts[1];
                    String parcelID = parts[2];
                    Customer customer = new Customer(sequenceNumber++, name, parcelID);
                    queue.addCustomer(customer);
                } else {
                    System.out.println("Customer Line Format Invalid: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame frame = new frame();
        Workers worker = new Workers(mapParcel, queue);
        new ControllerMain(frame, worker);

        frame.setVisible(true);
    }
}