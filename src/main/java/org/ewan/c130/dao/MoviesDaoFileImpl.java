package org.ewan.c130.dao;

import org.ewan.c130.dto.Movie;

import java.io.*;
import java.util.*;

public class MoviesDaoFileImpl implements MoviesDao {

    public static final String MOVIES_FILE = "movies.txt";
    public static final String DELIMITER = "::";

    private Map<String, Movie> movies = new HashMap<>();

    @Override
    public Movie addMovie(String MovieId, Movie Movie)
            throws MoviesDaoException {
        loadRoster();
        Movie newMovie = movies.put(MovieId, Movie);
        writeRoster();
        return newMovie;
    }

    @Override
    public List<Movie> getAllMovies()
            throws MoviesDaoException {
        loadRoster();
        return new ArrayList(movies.values());
    }

    @Override
    public Movie getMovie(String MovieId)
            throws MoviesDaoException {
        loadRoster();
        return movies.get(MovieId);
    }

    @Override
    public Movie removeMovie(String MovieId)
            throws MoviesDaoException {
        loadRoster();
        Movie removedMovie = movies.remove(MovieId);
        writeRoster();
        return removedMovie;
    }

    private Movie unmarshallMovie(String MovieAsText) {

        String[] MovieTokens = MovieAsText.split(DELIMITER);

        String title = MovieTokens[0];

        Movie MovieFromFile = new Movie(title);

        MovieFromFile.setReleaseDate(MovieTokens[1]);

        MovieFromFile.setMPAARating(MovieTokens[2]);

        MovieFromFile.setDirectorName(MovieTokens[3]);

        MovieFromFile.setStudio(MovieTokens[4]);

        MovieFromFile.setUserRatingNote(MovieTokens[5]);

        return MovieFromFile;
    }

    private void loadRoster() throws MoviesDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(MOVIES_FILE)));
        } catch (FileNotFoundException e) {
            throw new MoviesDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        String currentLine;
        Movie currentMovie;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentMovie = unmarshallMovie(currentLine);
            movies.put(currentMovie.getTitle(), currentMovie);
        }
        // close scanner
        scanner.close();
    }

    private String marshallMovie(Movie aMovie) {

        String MovieAsText = aMovie.getTitle() + DELIMITER;


        // release date
        MovieAsText += aMovie.getReleaseDate() + DELIMITER;

        // mpaa
        MovieAsText += aMovie.getMPAARating() + DELIMITER;

        // FirstName
        MovieAsText += aMovie.getDirectorName() + DELIMITER;

        // LastName
        MovieAsText += aMovie.getStudio() + DELIMITER;

        MovieAsText += aMovie.getUserRatingNote();

        return MovieAsText;
    }


    private void writeRoster() throws MoviesDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(MOVIES_FILE));
        } catch (IOException e) {
            throw new MoviesDaoException(
                    "Could not save Movie data.", e);
        }


        String MovieAsText;
        List<Movie> MovieList = this.getAllMovies();
        for (Movie currentMovie : MovieList) {
            MovieAsText = marshallMovie(currentMovie);
            out.println(MovieAsText);
            out.flush();
        }
        out.close();
    }

}
