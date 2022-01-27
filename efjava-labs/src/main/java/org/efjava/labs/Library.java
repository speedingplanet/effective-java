package org.efjava.labs;

import java.util.Arrays;
import java.util.List;

public class Library<T> {
  private T[] items;
  private int size = 0;
  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  @SuppressWarnings("unchecked")
  public Library() {
    items = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
  }

  public void add(T item) {
    ensureCapacity();
    items[size++] = item;
  }

  public T remove(T item) {
    boolean isFound = false;
    for(int x = 0; x < items.length; x++) {
      if (items[x].equals(item)) {
        // Oh no, a sparse array
        items[x] = null;
        return item;
      }
    }

    // Ew, guess we'll solve this with Optionals!
    return null;
  }

  public void asList(List<? super T> destination) {
    for (T item: items) {
      if (item != null) {
        destination.add(item);
      }
    }
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  private void ensureCapacity() {
    if (items.length == size) {
      items = Arrays.copyOf(items, 2 * size + 1);
    }
  }

}
