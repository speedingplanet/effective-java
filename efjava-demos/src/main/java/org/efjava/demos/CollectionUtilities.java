package org.efjava.demos;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class CollectionUtilities {

  /*
  Given a List of values, for example, 1, 2, 2, 2, 3, 3, 4, 5, 6, 7, 7, 7, 7
  Return a frequency analysis that looks like this:
  1: 1
  2: 3
  3: 2
  4: 1
  5: 1
  6: 1
  7: 4
   */
  public static <T> Map<T, Integer> frequencyAnalyzer(T[] numbers) {
    Map<T, Integer> frequency = new HashMap<>();
    for (T i : numbers) {
      if (frequency.containsKey(i)) {
        frequency.put(i, frequency.get(i) + 1);
      } else {
        frequency.put(i, 1);
      }
    }
    return frequency;
  }

  // public static int itemsInCommon(Set s1, Set s2) {
  public static int itemsInCommon(Set<?> s1, Set<?> s2) {
    int commonCount = 0;
    for (Object item : s1) {
      if (s2.contains(item)) {
        commonCount++;
      }
    }

    return commonCount;
  }

  public static Map<?, Integer> frequencyAnalyzerZhe(Object[] numbers) {
    Map<Object, Integer> frequency = new HashMap<>();
    for (Object i : numbers) {
      if (frequency.containsKey(i)) {
        frequency.put(i, frequency.get(i) + 1);
      } else {
        frequency.put(i, 1);
      }
    }
    return frequency;
  }

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
