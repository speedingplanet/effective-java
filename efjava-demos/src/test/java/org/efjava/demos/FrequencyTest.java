package org.efjava.demos;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FrequencyTest {
  @Test
  public void minimalTest() {
    Integer[] numbers = { 1, 2, 2, 3, 3, 3 };
    Map<Integer, Integer> results = CollectionUtilities.frequencyAnalyzer(numbers);

    long resultsOne = results.get(1);
    long resultsTwo = results.get(2);
    assertEquals(resultsOne, 1);
    assertEquals(resultsTwo, 2);
  }

  @Test
  public void stringTest() {
    String[] letters = { "a", "b", "b", "c", "c", "d", "d", "d" };
    Map<String, Integer> results = CollectionUtilities.frequencyAnalyzer(letters);

    assertEquals(results.get("a"), Integer.valueOf(1));
    assertEquals(results.get("b"), Integer.valueOf(2));
  }

  /*
  @Test
  public void zheTest() {
    String[] letters = { "a", "b", "b", "c", "c", "d", "d", "d" };
    Map<String, Integer> results = CollectionUtilities.frequencyAnalyzerZhe(letters);

    assertEquals(results.get("a"), Integer.valueOf(1));
    assertEquals(results.get("b"), Integer.valueOf(2));
  }
  */
}
