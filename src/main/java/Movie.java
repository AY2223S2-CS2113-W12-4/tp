/**
 * Movie class containing the basic essentials of a movie.
 *
 * A movie is categorised by its title (name), titleID (Alphanumeric way to categorise)
 * Year of release, runtime/length (in minutes), and an array of up to 3 Genres.
 * Data is provided by IMDB.
 */
public class Movie implements Comparable<Movie> {
    private final String titleID;
    private final String title;
    private final int year;
    private final int runTimeMinutes;
    private final String[] genres;

    /**
     * Default constructor.
     * @param titleID The Unique ID assigned to a movie.
     * @param title The full title of the movie.
     * @param year The year the movie was made.
     * @param runTimeMinutes The runtime (in minutes).
     * @param genres String[] of Genres, up to 3.
     */
    public Movie(String titleID, String title, int year, int runTimeMinutes, String... genres) {
        this.titleID = titleID;
        this.title = title;
        this.year = year;
        this.runTimeMinutes = runTimeMinutes;
        this.genres = genres;
    }

    /**
     * Overloaded constructor.
     * @param movie A movie.
     */
    public Movie(Movie movie) {
        this(movie.getTitleID(), movie.getTitle(), movie.getYear(), movie.getRunTimeMinutes(), movie.getGenres());
    }

    /**
     * Default comparator.
     * Sorting rules: Alphabetical title, then year.
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Movie o) {
        return (this.getTitle().equals(o.getTitle())) ?
                (this.getYear() - o.getYear())
                : (this.getTitle().compareTo(o.getTitle()));
    }

    /* Getters all here below */
    public String getTitleID() {
        return titleID;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getRunTimeMinutes() {
        return runTimeMinutes;
    }

    public String[] getGenres() {
        return genres;
    }
}
