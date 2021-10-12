package org.ewan.c130;

import org.ewan.c130.controller.MoviesController;
import org.ewan.c130.dao.MoviesDao;
import org.ewan.c130.dao.MoviesDaoFileImpl;
import org.ewan.c130.ui.MoviesView;
import org.ewan.c130.ui.UserIO;
import org.ewan.c130.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        MoviesView myView = new MoviesView(myIo);
        MoviesDao myDao = new MoviesDaoFileImpl();
        MoviesController controller =
                new MoviesController(myDao, myView);
        controller.run();
    }
}