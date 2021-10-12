package org.ewan.c130.controller;

import org.ewan.c130.dao.MoviesDao;
import org.ewan.c130.dao.MoviesDaoException;
import org.ewan.c130.dto.Movie;
import org.ewan.c130.ui.MoviesView;
import org.ewan.c130.ui.UserIO;
import org.ewan.c130.ui.UserIOConsoleImpl;

import java.util.List;

public class MoviesController {

    private UserIO io = new UserIOConsoleImpl();
    private MoviesView view;
    private MoviesDao dao;

    public MoviesController(MoviesDao dao, MoviesView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listMovies();
                        break;
                    case 2:
                        createMovie();
                        break;
                    case 3:
                        viewMovie();
                        break;
                    case 4:
                        removeMovie();
                        break;
                    case 5:
                        editMovie();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (MoviesDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createMovie() throws MoviesDaoException {
        view.displayCreateMovieBanner();
        Movie newMovie = view.getNewMovieInfo();
        dao.addMovie(newMovie.getTitle(), newMovie);
        view.displayCreateSuccessBanner();
    }

    private void listMovies() throws MoviesDaoException {
        view.displayDisplayAllBanner();
        List<Movie> MovieList = dao.getAllMovies();
        view.displayMovieList(MovieList);
    }

    private void viewMovie() throws MoviesDaoException {
        view.displayDisplayMovieBanner();
        String MovieTitle = view.getMovieTitleChoice();
        Movie Movie = dao.getMovie(MovieTitle);
        view.displayMovie(Movie);
    }

    private void removeMovie() throws MoviesDaoException {
        view.displayRemoveMovieBanner();
        String MovieTitle = view.getMovieTitleChoice();
        Movie removedMovie = dao.removeMovie(MovieTitle);
        view.displayRemoveResult(removedMovie);
    }

    private void editMovie() throws MoviesDaoException {
        view.displayEditMovieBanner();
        String MovieTitle = view.getRevisedTitleChoice();
        Movie removedMovie = dao.removeMovie(MovieTitle);
        Movie newMovie = view.getEditedMovieInfo();
        dao.addMovie(newMovie.getTitle(), newMovie);
        view.displayEditResult(removedMovie, newMovie);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
