package org.ewan.c130.dao;

import org.ewan.c130.dto.Movie;

import java.util.List;

    public interface MoviesDao {

        Movie addMovie(String MovieId, Movie Movie)
                throws MoviesDaoException;


        List<Movie> getAllMovies()
                throws MoviesDaoException;


        Movie getMovie(String MovieId)
                throws MoviesDaoException;


        Movie removeMovie(String MovieId)
                throws MoviesDaoException;

    }