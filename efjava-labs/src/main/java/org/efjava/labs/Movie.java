package org.efjava.labs;

public class Movie extends Media {
  private final int year;

  public Movie(String title, String director, int year) {
    super(title, director);
    this.year = year;
  }

  public String getDirector() {
    return getCreator();
  }

  public int getYear() {
    return year;
  }
}
