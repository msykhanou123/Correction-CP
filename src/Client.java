import java.util.ArrayList;
import java.util.List;

public class Client {
    private final String name;
    private final String email;
    private List<Reservation> reservations = new ArrayList<>();

    public Client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Reservation reserve (Seance seance, Place place){
        if (seance.isFull()){
            System.out.println("Séance est complète");
            return null;
        }else if (place.isOccupiedBySeance(seance)){
            System.out.println("Choisissez une autre place");
            return null;
        }
        else{

            Reservation reservation = new Reservation(this, seance, place);
            reservations.add(reservation);
            seance.getReservations().add(reservation);
            place.setOccupied(seance, true);
            return reservation;
        }
    }
}
