import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cinema {
    private final String name;
    private final String address;
    private List<Salle> salles = new ArrayList<>();
    private List<Film> films = new ArrayList<>();
    private List<Seance> seances = new ArrayList<>();

    public Cinema(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Salle> getSalles() {
        return salles;
    }

    public void addSalle (Salle salle){
        salles.add(salle);
    }

    public List<Film> getFilms() {
        return films;
    }

    public void addFilm (Film film){
        films.add(film);
    }
    public List<Seance> getSeances() {
        return seances;
    }

    public void scheduleSeance(Film film, Salle salle, Date date, Time time){
        Seance seance = new Seance(film, salle, date, time);
        for (Place place : salle.getPlaces()){
            place.setOccupied(seance, false);
        }
        seances.add(seance);
    }

    public List<Seance> listSeanceByFilm(Film film){
        List<Seance> res = new ArrayList<>();
        for (Seance seance : seances){
            if (seance.getFilm().equals(film))
                res.add(seance);
        }
        return res;
    }

    public List<Seance> listSeanceByFilmOnDate(Film film, Date date){
        List<Seance> res = new ArrayList<>();
        for (Seance seance : seances){
            if (seance.getFilm().equals(film) && seance.getDate().equals(date))
                res.add(seance);
        }
        return res;
    }

}
