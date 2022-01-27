package org.efjava.demos;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamsTests {
  List<String> names;

  @Before
  public void setup() {
    names = Arrays.asList("Haoyang", "Harshini", "Jolene", "Junrao", "Paiyang", "Shaoyang",
                          "Sravanthi", "Xiaochen", "Zhe" );
  }

  @Test
  public void classicIteration() {
    for (String name: names) {
      System.out.println(name);
    }
  }

  @Test
  public void streamIteration() {
    names.stream().forEach(System.out::println);
  }

  @SuppressWarnings({"Convert2MethodRef"})
  @Test
  public void streamAndLambdaIteration() {
    names.stream().forEach(name -> System.out.println(name));
  }

  @Test
  public void funWithStreams() {
    Comparator<String> shortAscending = (n1, n2) -> n1.length() - n2.length();

    // names.stream().sorted(shortAscending).forEach(System.out::println);
    // names.stream().sorted((n1, n2) -> n1.length() - n2.length()).forEach(System.out::println);
    names.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);
  }

}
