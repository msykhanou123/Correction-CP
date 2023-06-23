public class Reservation {
    private Client client;
    private Seance seance;
    private Place place;

    public Reservation(Client client, Seance seance, Place place) {
        this.client = client;
        this.seance = seance;
        this.place = place;
    }

    public Client getClient() {
        return client;
    }

    public Seance getSeance() {
        return seance;
    }

    public Place getPlace() {
        return place;
    }

    public String toString (){
        return "Film : "+ getSeance().getFilm().getName()+"\n"+
                "Salle : "+getSeance().getSalle().getName()+"\n"+
                "Place : "+getPlace().getName();
    }
}
