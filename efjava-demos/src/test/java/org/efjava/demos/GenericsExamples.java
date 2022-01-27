package org.efjava.demos;

import org.efjava.demos.CustomStack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("unused")
public class GenericsExamples {
  @Test
  public void creatingLists() {
    List<String> fixedSizeNames = Arrays.asList("John", "Dan", "Tim", "Andres",
                                                "Hector");
    // Combine with the assignment above into a one-liner
    List<String> unfixedNames = new ArrayList<>(fixedSizeNames);
    List<String> unmodifiableNames = List.of("John", "Dan", "Tim", "Andres", "Hector");
  }

  @Test
  public void unboundedWildcardTest() {

    // A List that can only contain an unknown type (weird)
    List<?> unboundedlist = new ArrayList<>();

    // Not allowed, checked at compile-time
    // unboundedlist.add("Foo");

    // Allowed
    unboundedlist.add(null);
  }

  @Test
  public void pushAllInvariantTest() {
    CustomStack<Number> stack = new CustomStack<>();
    Iterable<Number> numbers = List.of(1, 2, 3, 4, 5);
    Iterable<Integer> integers = List.of(6, 7, 8, 9, 10);

    stack.pushAllInvariant(numbers);
    assertFalse(stack.isEmpty());

    // Compile-time error
    // stack.pushAllInvariant(integers);
  }

  @Test
  public void pushAllTest() {
    CustomStack<Number> stack = new CustomStack<>();
    Iterable<Number> numbers = List.of(1, 2, 3, 4, 5);
    Iterable<Integer> integers = List.of(6, 7, 8, 9, 10);

    stack.pushAll(numbers);
    assertFalse(stack.isEmpty());
    assertEquals(5, stack.size());

    // No problem!
    stack.pushAll(integers);
    assertFalse(stack.isEmpty());
    assertEquals(10, stack.size());
  }

  @Test
  public void popAllInvariantTest() {
    CustomStack<Number> stack = new CustomStack<>();
    Iterable<Number> numbers = List.of(1, 2, 3, 4, 5);
    stack.pushAll(numbers);

    Collection<Object> objects = new ArrayList<>();

    // Won't compile, because Number is invariant and can't be treated
    // as an Object
    // stack.popAllInvariant(objects);
  }

  @Test
  public void popAllTest() {
    CustomStack<Number> stack = new CustomStack<>();
    Iterable<Number> numbers = List.of(1, 2, 3, 4, 5);
    stack.pushAll(numbers);

    Collection<Object> objects = new ArrayList<>();

    // Works fine
    stack.popAll(objects);
    assertTrue(stack.isEmpty());
  }
}
