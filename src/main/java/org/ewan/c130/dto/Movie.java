package org.ewan.c130.dto;

import java.time.LocalDate;

public class Movie {
    private String title;
    private String releaseDate;
    private String MPAARating;
    private String directorName;
    private String Studio;
    private String userRatingNote;

    public Movie(String title){
        this.title = title;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMPAARating() {
        return MPAARating;
    }

    public void setMPAARating(String MPAARating) {
        this.MPAARating = MPAARating;
    }

    public String getStudio() {
        return Studio;
    }

    public void setStudio(String studio) {
        Studio = studio;
    }

    public String getUserRatingNote() {
        return userRatingNote;
    }

    public void setUserRatingNote(String userRatingNote) {
        this.userRatingNote = userRatingNote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}