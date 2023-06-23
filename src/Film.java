import java.util.Date;

public class Film {
    private final String name;
    private final String synopsis;
    private final Date releaseDate;

    public Film(String name, String synopsis, Date releaseDate) {
        this.name = name;
        this.synopsis = synopsis;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }
}
