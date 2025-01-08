public class Parcel {
    private String parcelID;
    private int daysInDepot;
    private double weight;
    private String dimensions;
    private boolean isCollected;

    public Parcel(String parcelID, int daysInDepot, double weight, String dimensions) {
        this.parcelID = parcelID;
        this.daysInDepot = daysInDepot;
        this.weight = weight;
        this.dimensions = dimensions;
        this.isCollected = false;
    }

    public void markAsCollected() {
        this.isCollected = true;
    }

    public double calculateFee() {
        double baseFee = 5.0;
        double weightFee = this.weight * 0.5;
        double daysFee = this.daysInDepot * 0.2;
        return baseFee + weightFee + daysFee;
    }

    public String getParcelID() {
        return parcelID;
    }

    public int getDaysInDepot() {
        return daysInDepot;
    }

    public double getWeight() {
        return weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public boolean isCollected() {
        return isCollected;
    }
}
