import java.util.ArrayList;
import java.util.Collection;

/**
 * MovieList class containing the list of movies.
 * A movie list can be either a watched list or a to-watch list.
 */
public class MovieList {
    protected ArrayList<Movie> movieList;

    /**
     * Default constructed for empty MovieList.
     */
    public MovieList() {
        this.movieList = new ArrayList<Movie>();
    }

    /**
     * Overloaded constructor with filled MovieList.
     * @param movieList List of movies.
     */
    public MovieList(Collection<Movie> movieList) {
        this.movieList = new ArrayList<Movie>(movieList);
    }

    /**
     * Add a movie to the contained list.
     * @param movie a movie.
     */
    public void add(Movie movie) {
        this.movieList.add(movie);
    }

    /**
     * Remove a specific movie from the contained list.
     * @param movie a movie.
     */
    public void remove(Movie movie) {
        this.movieList.remove(movie);
    }

    /**
     * Remove a movie from the contained list.
     * @param index 1-indexed index of the movie in list.
     */
    public void remove(int index) {
        index = index - 1; // Offset 1-index
        this.movieList.remove(index);
    }
}
