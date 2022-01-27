package org.efjava.demos;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class OptionalTests {
  @Test
  public void creatingOptionals() {
    Optional<String> greeting = Optional.of("Hello");

    // Runtime NullPointerException, boo!
    // Optional<String> notNull = Optional.of(null);

    Optional<String> nullable = Optional.ofNullable(null);
    Optional<String> empty = Optional.empty();

    assertTrue(greeting.isPresent());
    assertTrue(nullable.isEmpty());
    assertThrows(NoSuchElementException.class, () -> empty.get());

    greeting.ifPresent(v -> System.out.printf("ifPresent(): The value is \"%s\"%n", v));

    // orElse runs even if nullable is populated
    System.out.printf("orElse(): nullable's value is %s%n", nullable.orElse("[null]"));

    // orElseGet only runs if empty is empty
    System.out.printf("orElseGet(): empty's value is %s%n",
                      empty.orElseGet(() -> "empty, but here's an alternate value"));

  }
}
