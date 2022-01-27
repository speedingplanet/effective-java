package org.efjava.demos;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class CollectionUtilities {
  public static <E extends Comparable<E>> Optional<E> max(Collection<E> collection) {
    if (collection.isEmpty()) {
      return Optional.empty();
    }

    E result = null;
    for (E element : collection) {
      if (result == null || element.compareTo(result) > 0) {
        result = Objects.requireNonNull(element);
      }
    }

    return Optional.of(result);

  }
}
