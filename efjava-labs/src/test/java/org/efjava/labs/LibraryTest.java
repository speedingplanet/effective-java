package org.efjava.labs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class LibraryTest {

  @Test
  public void testAdd() {
    Library<Book> books = new Library<>();
    assertThat(books.size(), is(0));
    Book gatsby = new Book("The Great Gatsby", "F. Scott Fitzgerald");
    books.add(gatsby);
    assertThat(books.size(), is(1));
  }

  @Test
  public void testRemove() {
    Library<Book> books = new Library<>();
    assertThat(books.size(), is(0));
    Book gatsby = new Book("The Great Gatsby", "F. Scott Fitzgerald");
    books.add(gatsby);
    Book removedGatsby = books.remove(gatsby);
    assertThat(removedGatsby, notNullValue());
    assertThat(removedGatsby, is(gatsby));
  }

  @Test
  public void testAddVariant() {
    Library<Media> mediaLibrary = new Library<>();
    assertThat(mediaLibrary.size(), is(0));
    Book gatsby = new Book("The Great Gatsby", "F. Scott Fitzgerald");
    mediaLibrary.add(gatsby);
    assertThat(mediaLibrary.size(), is(1));
  }

  @Test
  public void testAsList() {
    Library<Book> books = new Library<>();
    Book gatsby = new Book("The Great Gatsby", "F. Scott Fitzgerald");
    books.add(gatsby);
    List<Media> mediaLibrary = new ArrayList<>();
    books.asList(mediaLibrary);
    assertThat(books.size(), is(mediaLibrary.size()));
  }
}
