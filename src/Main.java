import java.sql.Time;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Date date1 = new Date(2023,6, 23);
        Date date2 = new Date(2023,6, 24);

        Time time1 = new Time(19, 55, 00);
        Time time2 = new Time(22, 00, 00);

        // Création du cinéma
        Cinema cinema = new Cinema("Cineplex", "123 Rue de Cinema");
        System.out.println("Cinema created: " + cinema.getName());

        // Création des place
        List<Place> places = new ArrayList<>();
        String[] rows = {"A", "B", "C", "D", "E", "F", "G"};
        for(String row : rows) {
            for(int i = 1; i <= 10; i++) {
                places.add(new Place(row + i));
            }
        }
        Salle salle1 = new Salle("1",70, places);
        Salle salle2 = new Salle("2",70, places);

        // Ajout des salles au cinéma
        cinema.addSalle(salle1);
        cinema.addSalle(salle2);
        System.out.println("Salles added to the cinema.");

        // Création des films
        Film film1 = new Film("Titanic", "Un bateau qui coule", new Date());
        Film film2 = new Film("Inception", "Un voyage dans les rêves", new Date());
        System.out.println("Films created: " + film1.getName() + ", " + film2.getName());

        // Ajout des films au cinéma
        cinema.addFilm(film1);
        cinema.addFilm(film2);
        System.out.println("La list des films dans le cinéma : "+cinema.getName());
        for (Film film : cinema.getFilms()){
            System.out.println(film.getName());
        }

        // Création des séances
        cinema.scheduleSeance(film1, salle1, date1, time1);
        cinema.scheduleSeance(film2, salle2, date1, time1);
        cinema.scheduleSeance(film1, salle1, date1, time2);
        cinema.scheduleSeance(film2, salle2 ,date1, time2);

        cinema.scheduleSeance(film1, salle1, date2, time1);
        cinema.scheduleSeance(film2, salle2, date2, time1);
        cinema.scheduleSeance(film1, salle1, date2, time2);
        cinema.scheduleSeance(film2, salle2 ,date2, time2);
        System.out.println("*********************");
        List<Seance> seancesFilm1 = cinema.listSeanceByFilmOnDate(film1, date1);
        for (Seance seance : seancesFilm1){
            System.out.println(seance);
        }

        // Création d'un client
        Client client1 = new Client("John Doe", "john.doe@example.com");
        Client client2 = new Client("Lyndia", "lyndia@example.com");
        Seance seance1 = seancesFilm1.get(0);
        System.out.println("Client created: " + client1.getName());

        // Réservation par le client
        Place placeChoisie = seance1.getSalle().getPlaceByName("C3");

        Reservation reservation1 = client1.reserve(seance1, placeChoisie);
        if (reservation1 != null) {
            System.out.println("Reservation : \n" + reservation1);
        }

        Reservation reservation2 = client2.reserve(seance1, placeChoisie);
        if (reservation2 != null) {
            System.out.println("Reservation : \n" + reservation2);
        }

        Place placeChoisie2 = seance1.getSalle().getPlaceByName("D9");

        reservation2 = client2.reserve(seance1, placeChoisie2);
        if (reservation2 != null) {
            System.out.println("Reservation : \n" + reservation2);
        }



    }
}
