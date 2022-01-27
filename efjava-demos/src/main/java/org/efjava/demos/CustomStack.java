package org.efjava.demos;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

// E for Element
@SuppressWarnings("unused")
public class CustomStack<E> {

  // Might want to try this, but it won't work
  private E[] elements;
  private int size = 0;
  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  // Type safe enough (push() ensures that we're only adding E)
  // but the runtime type will be Object[]
  // but again, no direct access to same
  @SuppressWarnings("unchecked")
  public CustomStack() {
    // Breaks
    // elements = new E[DEFAULT_INITIAL_CAPACITY];

    // Better
    elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
  }

  public void push(E element) {
    ensureCapacity();
    elements[size++] = element;
  }

  public void pushAllInvariant(Iterable<E> src) {
    for (E element: src) {
      push(element);
    }
  }

  // Producer (for PECS)
  public void pushAll(Iterable<? extends E> src) {
    for (E element: src) {
      push(element);
    }
  }

  public E pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }

    // Per the constuctor, above, we could also cast here,
    // (Assuming elements is now Object[])
    // but a one-time cast in the constructor is preferable
    // to an every-time cast in pop()
    E result = elements[--size];
    elements[size] = null;
    return result;
  }

  public void popAllInvariant(Collection<E> destination) {
    while(!isEmpty()) {
      destination.add(pop());
    }
  }

  // Consumer for PECS
  public void popAll(Collection<? super E> destination) {
    while(!isEmpty()) {
      destination.add(pop());
    }
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  private void ensureCapacity() {
    if (elements.length == size) {
      elements = Arrays.copyOf(elements, 2 * size + 1);
    }
  }
}
