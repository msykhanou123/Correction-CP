import java.util.ArrayList;
import java.util.List;

public class Salle {
    private String name;
    private final int CAPACITE;
    private List<Place> places = new ArrayList<>();

    public Salle(String name, int CAPACITE, List<Place> places) {
        this.name = name;
        this.CAPACITE = CAPACITE;
        this.places = places;
    }

    public String getName() {
        return name;
    }

    public int getCAPACITE() {
        return CAPACITE;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public Place getPlaceByName (String name){
        for (Place place : places){
            if (place.getName().equals(name))
                return place;
        }
        return null;
    }

}
