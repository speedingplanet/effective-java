package org.efjava.labs;

public class Book extends Media {

  public Book(String title, String author) {
    super(title, author);
  }

  public String getAuthor() {
    return getCreator();
  }

}
