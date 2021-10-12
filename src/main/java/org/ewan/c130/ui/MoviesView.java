package org.ewan.c130.ui;

import org.ewan.c130.dto.Movie;

import java.util.List;

public class MoviesView {

    private UserIO io;

    public MoviesView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Movies");
        io.print("2. Create New Movie");
        io.print("3. View a Movie");
        io.print("4. Remove a Movie");
        io.print("5. Edit an existing Movie");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public Movie getNewMovieInfo() {
        String title = io.readString("Please enter Title");
        String releaseDate = io.readString("Please enter release date");
        String MPAARating = io.readString("Please enter MPAARating");
        String directorName = io.readString("Please enter Director Name");
        String studio = io.readString("Please enter Studio name");
        String userNote = io.readString("Please enter User Note");
        Movie currentMovie = new Movie(title);
        currentMovie.setReleaseDate(releaseDate);
        currentMovie.setMPAARating(MPAARating);
        currentMovie.setDirectorName(directorName);
        currentMovie.setStudio(studio);
        currentMovie.setUserRatingNote(userNote);
        return currentMovie;
    }

    public Movie getEditedMovieInfo() {
        String title = io.readString("Please enter an updated Title");
        String releaseDate = io.readString("Please enter an updated release date");
        String MPAARating = io.readString("Please enter an updated MPAARating");
        String directorName = io.readString("Please enter an updated Director Name");
        String studio = io.readString("Please enter an updated Studio name");
        String userNote = io.readString("Please enter an updated User Note");
        Movie currentMovie = new Movie(title);
        currentMovie.setReleaseDate(releaseDate);
        currentMovie.setMPAARating(MPAARating);
        currentMovie.setDirectorName(directorName);
        currentMovie.setStudio(studio);
        currentMovie.setUserRatingNote(userNote);
        return currentMovie;
    }

    public void displayCreateMovieBanner() {
        io.print("=== Create Movie ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "Movie successfully created.  Please hit enter to continue");
    }

    public void displayMovieList(List<Movie> MovieList) {
        for (Movie currentMovie : MovieList) {
            String MovieInfo = String.format("Title : %s Release Date: %s  MPAA Rating: " +
                            "%s Studio: %s Director Name: %s User Notes %s",
                    currentMovie.getTitle(),
                    currentMovie.getReleaseDate(),
                    currentMovie.getMPAARating(),
                    currentMovie.getStudio(),
                    currentMovie.getDirectorName(),
                    currentMovie.getUserRatingNote());
            io.print(MovieInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Movies ===");
    }

    public void displayDisplayMovieBanner () {
        io.print("=== Display Movie ===");
    }

    public String getMovieTitleChoice() {
        return io.readString("Please enter the Movie Title.");
    }

    public String getRevisedTitleChoice() {
        return io.readString("Please enter the Movie Title you want to edit.");
    }

    public void displayMovie(Movie Movie) {
        if (Movie != null) {
            io.print(Movie.getTitle());
            io.print(Movie.getReleaseDate());
            io.print(Movie.getMPAARating());
            io.print(Movie.getDirectorName());
            io.print(Movie.getStudio());
            io.print(Movie.getUserRatingNote());
            io.print("");
        } else {
            io.print("No such Movie.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveMovieBanner () {
        io.print("=== Remove Movie ===");
    }

    public void displayRemoveResult(Movie MovieRecord) {
        if(MovieRecord != null){
            io.print("Movie successfully removed.");
        }else{
            io.print("No such Movie.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayEditMovieBanner () {
        io.print("=== Edit Movie ===");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayEditResult(Movie removedMovie,Movie addedMovie) {
        io.print(removedMovie.getTitle() + " was updated to contain the following information: ");
        displayMovie(addedMovie);
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
