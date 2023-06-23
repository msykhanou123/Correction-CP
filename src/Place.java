import java.util.HashMap;
import java.util.Map;

public class Place {
    private String name;
    private Map<Seance, Boolean> isOccupied = new HashMap<Seance, Boolean>();

    public Place(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOccupied (Seance seance, Boolean value){
        isOccupied.put(seance, value);
    }

    public Boolean isOccupiedBySeance (Seance seance){
        return isOccupied.get(seance);
    }
}
