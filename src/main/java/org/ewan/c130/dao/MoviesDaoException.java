package org.ewan.c130.dao;

public class MoviesDaoException extends Exception{

    public MoviesDaoException(String message) {
        super(message);
    }

    public MoviesDaoException(String message, Throwable cause) {
        super(message, cause);
    }

}