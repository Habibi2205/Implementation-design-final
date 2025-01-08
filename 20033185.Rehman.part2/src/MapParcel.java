import java.util.Collection;
import java.util.HashMap;

public class MapParcel {
    private HashMap<String, Parcel> parcelMap;

    public MapParcel() {
        this.parcelMap = new HashMap<>();
    }

    public void addParcel(Parcel parcel) {
        parcelMap.put(parcel.getParcelID(), parcel);
    }

    public Parcel getParcel(String parcelID) {
        return parcelMap.get(parcelID);
    }

    public void removeParcel(String parcelID) {
        parcelMap.remove(parcelID);
    }

    public Collection<Parcel> getAllParcels() {
        return parcelMap.values();
    }
}

