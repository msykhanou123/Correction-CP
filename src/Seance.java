import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Seance {
    private Film film;
    private Salle salle;
    private Date date;
    private Time time;
    private List<Reservation> reservations = new ArrayList<>();

    public Seance(Film film, Salle salle, Date date, Time time) {
        this.film = film;
        this.salle = salle;
        this.date = date;
        this.time = time;
    }

    public Film getFilm() {
        return film;
    }

    public Salle getSalle() {
        return salle;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public boolean isFull (){
        if (reservations.size()==salle.getCAPACITE()){
            return true;
        }
        return false;
    }

    public String toString (){
        return "Film : "+ getFilm().getName()+"\n"+
                getDate()+ " - " + getTime() +"\n"+
                "Nombre de places restant:"+ (salle.getCAPACITE() - reservations.size());
    }
}
